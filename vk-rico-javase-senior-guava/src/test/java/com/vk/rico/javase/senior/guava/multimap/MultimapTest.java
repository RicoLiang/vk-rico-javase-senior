package com.vk.rico.javase.senior.guava.multimap;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.vk.rico.javase.senior.guava.multimap.vo.UebOrderDetailVO;

public class MultimapTest {

	@Test
	public void testMultimap01() {
		UebOrderDetailService detailService = new UebOrderDetailService();
		List<UebOrderDetailVO> resultList = detailService.getList(null);

		Multimap<Integer, UebOrderDetailVO> resultMap = Multimaps.index(resultList, p -> p.getOrderId());
		System.out.println(resultMap.size());

		Collection<UebOrderDetailVO> list = resultMap.get(222);
		System.out.println(list.size());
	}

	@Test
	public void testMultimap02() throws Exception {
		UebOrderDetailService detailService = new UebOrderDetailService();
		List<UebOrderDetailVO> resultList = detailService.getList(null);

		Multimap<Integer, UebOrderDetailVO> resultMap = Multimaps.index(resultList, p -> p.getOrderId());
		Iterator<UebOrderDetailVO> iteratorVo = resultMap.get(222).iterator();
		if (iteratorVo.hasNext()) {
			UebOrderDetailVO orderDetailVo = iteratorVo.next();
			System.out.println("站点: " + orderDetailVo.getSite());
		} else {
			throw new Exception("订单缺少交易信息");
		}
	}
}
