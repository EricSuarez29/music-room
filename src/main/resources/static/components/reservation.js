const d = document,
	$slctBranchOffices = d.getElementById('branchOffices'),
	$slctRooms = d.getElementById('rooms'),
	$datepicker = d.getElementById('datepicker'),
	$divSchedules = d.getElementById('divSchedules');


(async () => {
	const branchOffices = await (await fetch('/api/branch-oficces')).json();
	$slctBranchOffices.innerHTML += branchOffices.map(BranchOffice).join("");
})();

const BranchOffice = ({ name, id }) => `<option value="${id}">${name}</option>`;

const ScheduleInputCheck = ({ id, start, end}) => (`
	<div class="m-2 form-check">
		<input type="checkbox" name="schedules"
			class="form-check-input"
			id="${'btn-check-' + id + '-outlined'}"
			value="${id}" autocomplete="off" /> 
		<label
			class="form-check-label"
			for="${'btn-check-' + id + '-outlined'}">
			${start + ' - ' + end}
		</label>
	</div>	
`);

async function fetchRoomsByBranchOfficeId(id) {
	const rooms = await (await fetch(`/api/branch-oficces/${id}/rooms`)).json()
	$slctRooms.innerHTML = `<option value="0">Selecione una Sala</option>${rooms.map(BranchOffice).join("")}`;
}

async function fetchSchedulesByDate(date){
	const schedules = await (await fetch(`/api/reservation/schedule?date=${date}`)).json();
	console.table(schedules)
	$divSchedules.innerHTML = schedules.map(ScheduleInputCheck).join("");
}


d.addEventListener('change', async (evt) => {
	const $target = evt.target;
	if ($slctBranchOffices === $target) {
		const branchOfficeId = $slctBranchOffices.options[$slctBranchOffices.selectedIndex].value;
		if (branchOfficeId === "0") return;
		await fetchRoomsByBranchOfficeId(branchOfficeId);
	}
	
	if($target === $datepicker){
		if($datepicker.value){
			console.log($datepicker.value)
			await fetchSchedulesByDate($datepicker.value)
		} else { 
				
		}
	}	
});