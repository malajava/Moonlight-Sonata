package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * TCatelog generated by MyEclipse Persistence Tools
 * 论坛模板
 */

public class TCatelog implements java.io.Serializable
{

	private Integer id;
	private String name;
	private String del;
	
	private List zhuti_list_all=new ArrayList();
	
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	
	public List getZhuti_list_all()
	{
		return zhuti_list_all;
	}
	public void setZhuti_list_all(List zhuti_list_all)
	{
		this.zhuti_list_all = zhuti_list_all;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

}