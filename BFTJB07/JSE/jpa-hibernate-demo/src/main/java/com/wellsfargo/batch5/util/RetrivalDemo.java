package com.wellsfargo.batch5.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.wellsfargo.batch5.entities.AdbSubscriber;

public class RetrivalDemo {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		AdbSubscriber sub1 = em.find(AdbSubscriber.class, 7);
		System.out.println(sub1);
		
		String jpqlQryString = "SELECT s FROM AdbSubscriber s";
		TypedQuery<AdbSubscriber> qry = em.createQuery(jpqlQryString,AdbSubscriber.class);
		List<AdbSubscriber> subs=qry.getResultList();
		for(AdbSubscriber s : subs) {
			System.out.println(s);
		}
	}

}
