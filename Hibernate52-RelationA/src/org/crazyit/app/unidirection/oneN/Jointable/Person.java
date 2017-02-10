package org.crazyit.app.unidirection.oneN.Jointable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Entity
@Table(name="person_inf")
public class Person
{
	// ��ʶ����
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	// �����Personʵ�����й�����Addressʵ��
	@OneToMany(targetEntity=Address.class)
	// ӳ�����ӱ�Ϊperson_address
	@JoinTable(name="person_address",
		// �������ӱ�����Ϊperson_id������У�������в��յ�ǰʵ���Ӧ����������
		joinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id"),
		// �������ӱ�����Ϊaddress_id������У�
		// ������в��յ�ǰʵ��Ĺ���ʵ���Ӧ����������
		inverseJoinColumns=@JoinColumn(name="address_id"
			, referencedColumnName="address_id", unique=true)
	)
	private Set<Address> addresses
		= new HashSet<>();

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// age��setter��getter����
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// addresses��setter��getter����
	public void setAddresses(Set<Address> addresses)
	{
		this.addresses = addresses;
	}
	public Set<Address> getAddresses()
	{
		return this.addresses;
	}
}