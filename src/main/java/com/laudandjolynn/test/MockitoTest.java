package com.laudandjolynn.test;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author: Laud
 * @email: htd0324@gmail.com
 * @date: 2014年10月30日 上午9:37:19
 * @copyright: www.laudandjolynn.com
 */
public class MockitoTest {
	@Test
	public void testMockito() {
		@SuppressWarnings("rawtypes")
		List list = Mockito.mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("abc");
		System.out.println(list.get(0));
	}
}
