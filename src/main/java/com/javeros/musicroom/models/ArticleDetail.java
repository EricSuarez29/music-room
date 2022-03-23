package com.javeros.musicroom.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article_detail")
public class ArticleDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "article_id")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Article article;
	
	@Column(nullable = false)
	private Integer amount;

	@JoinColumn(name = "branch_office_id")
	@ManyToOne
	private BranchOffice branchOffice;
	
	public ArticleDetail() {
	}

	public ArticleDetail(Long id, Article article, Integer amount, BranchOffice branchOffice) {
		super();
		this.id = id;
		this.article = article;
		this.amount = amount;
		this.branchOffice = branchOffice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BranchOffice getBranchOffice() {
		return branchOffice;
	}

	public void setBranchOffice(BranchOffice branchOffice) {
		this.branchOffice = branchOffice;
	}

	private static final long serialVersionUID = 1L;
}
