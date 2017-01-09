package com.scloudpay.testframe.admin.sysmgr.web;

import java.util.List;


/**
 * 树形结构数据
 * 
 * @author TanDong
 *
 */
public class TreeNode {
	
	private String id;
	
	private String text;
	
	private List<TreeNode> children;
	
	private String url;//链接
	
	private String state;
	
	private String icon = "icon-nav";//图标
	
	private String extValue1;//扩展属性值
	
	private String extValue2;//扩展属性值
	
	private String extValue3;//扩展属性值
	
	private String extValu4;//扩展属性值
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getExtValue1() {
		return extValue1;
	}

	public void setExtValue1(String extValue1) {
		this.extValue1 = extValue1;
	}

	public String getExtValue2() {
		return extValue2;
	}

	public void setExtValue2(String extValue2) {
		this.extValue2 = extValue2;
	}

	public String getExtValue3() {
		return extValue3;
	}

	public void setExtValue3(String extValue3) {
		this.extValue3 = extValue3;
	}

	public String getExtValu4() {
		return extValu4;
	}

	public void setExtValu4(String extValu4) {
		this.extValu4 = extValu4;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
