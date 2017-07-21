package com.vk.rico.javase.senior.guava.multimap;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.vk.rico.javase.senior.guava.multimap.vo.UebOrderDetailVO;

public class UebOrderDetailService {

	public static boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	public List<UebOrderDetailVO> getList(List<Integer> listId) {
		List<UebOrderDetailVO> results = Lists.newArrayListWithCapacity(3);

		UebOrderDetailVO vo1 = new UebOrderDetailVO();
		vo1.setId(476);
		vo1.setOrderId(222);
		vo1.setOrderNo("CO1707050137792XP");
		vo1.setPlatformCode("SHOPEE");
		vo1.setTransactionNo("170705144231HY9");
		vo1.setSite("tw");

		UebOrderDetailVO vo2 = new UebOrderDetailVO();
		vo2.setId(477);
		vo2.setOrderId(222);
		vo2.setOrderNo("CO1707050137792XP");
		vo2.setPlatformCode("SHOPEE");
		vo2.setTransactionNo("170705144231HY9");
		vo2.setSite("tw");

		UebOrderDetailVO vo3 = new UebOrderDetailVO();
		vo3.setId(478);
		vo3.setOrderId(222);
		vo3.setOrderNo("CO1707050137792XP");
		vo3.setPlatformCode("SHOPEE");
		vo3.setTransactionNo("170705144231HY9");
		vo3.setSite("tw");

		UebOrderDetailVO vo4 = new UebOrderDetailVO();
		vo4.setId(479);
		vo4.setOrderId(222);
		vo4.setOrderNo("CO1707050137792XP");
		vo4.setPlatformCode("SHOPEE");
		vo4.setTransactionNo("170705144231HY9");
		vo4.setSite("tw");

		UebOrderDetailVO vo5 = new UebOrderDetailVO();
		vo5.setId(480);
		vo5.setOrderId(222);
		vo5.setOrderNo("CO1707050137792XP");
		vo5.setPlatformCode("SHOPEE");
		vo5.setTransactionNo("170705144231HY9");
		vo5.setSite("tw");

		UebOrderDetailVO vo6 = new UebOrderDetailVO();
		vo6.setId(480);
		vo6.setOrderId(223);
		vo6.setOrderNo("CO1707060087544XP");
		vo6.setPlatformCode("SHOPEE");
		vo6.setTransactionNo("17070115194M375");
		vo6.setSite("sg");

		results.add(vo1);
		results.add(vo2);
		results.add(vo3);
		results.add(vo4);
		results.add(vo5);
		results.add(vo6);
		return results;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getListt(List<Integer> listId) {
		return (List<T>) getList(listId);
	}
}
