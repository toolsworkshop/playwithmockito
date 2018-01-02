package edu.matchers;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void test() {
		List<Integer> list = Arrays.asList(99,100);
		assertThat(list, hasSize(4));
	}

}
