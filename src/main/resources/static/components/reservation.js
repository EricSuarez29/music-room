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

async function fetchSchedulesByDate(date, roomId){
	const schedules = await (await fetch(`/api/reservation/schedule?date=${date}&room=${roomId}`)).json();
	console.table(schedules)
	$divSchedules.innerHTML = schedules.map(ScheduleInputCheck).join("");
}


// customer searching 

const fetchEmpleados = async (pattern) => await ( await fetch(`/api/reservation/customer?filter=${pattern}`)).json();

const searchWrapper = document.querySelector(".search-input"),
        inputBox = searchWrapper.querySelector("input"),
        suggBox = searchWrapper.querySelector(".autocom-box");

inputBox.onkeyup = async (evt) => {
    let userData = evt.target.value;
    let emptyArray = [];
    if (userData) {

        let suggestions = await fetchEmpleados(userData);

        emptyArray = suggestions.slice(0, 4).map(data => {
            return `<li class="btn-person bg-dark text-white" data-id="${data.id}">${data.name + " " + data.lastName}</li>`;
        });

        searchWrapper.classList.add("active");
        showSuggestions(emptyArray);

        let allList = suggBox.querySelectorAll("li");
        for (let i = 0; i < allList.length; i++) {
            allList[i].setAttribute("onclick", "select(this)");
        }
    } else {
        searchWrapper.classList.remove("active");
    }

};

function select(element) {
    let selectData = element.textContent;
    inputBox.value = selectData;
    let id = parseInt(element.dataset.id);
	d.getElementById('customer-id').value = id;	
    searchWrapper.classList.remove("active");
}

function showSuggestions(list) {
    if (list)
        suggBox.innerHTML = list.join("");
}

// -------------------------------------------------------------------------

d.addEventListener('change', async (evt) => {
	const $target = evt.target;
	if ($slctBranchOffices === $target) {
		const branchOfficeId = $slctBranchOffices.options[$slctBranchOffices.selectedIndex].value;
		if (branchOfficeId === "0") return;
		await fetchRoomsByBranchOfficeId(branchOfficeId);
	}
	
	if($target === $datepicker || $target === $slctRooms){
		let roomId = $slctRooms.options[$slctRooms.selectedIndex].value;
		if($datepicker.value && roomId > 0){
			await fetchSchedulesByDate($datepicker.value, roomId);
		} else { 
			$divSchedules.innerHTML = `
							<div class="card bg-light bg-opacity-25 border-primary text-center">
								<div class="card-body">
									<b>Aún no se ha selecionado una fecha o una sala</b>
								</div>
							</div>`
		}
	}	
});