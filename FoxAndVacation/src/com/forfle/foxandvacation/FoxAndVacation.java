package com.forfle.foxandvacation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * SRM 561 - FoxAndVacation
 * 
 * total값의 일수 동안 여행을 다닌다. 최대한 많은 지역을 방문하고자 한다. 여러 지역을 같은 날 방문할 수 없다. i라는 지역을
 * 방문하고자 한다면 d배열의 i인덱스 숫자값 만큼 머물러야만 하는 조건이 주어진다. 가령 total이 5이고 d가 { 2,1,3 } 이라면,
 * 1번 index인 지역을 하루간 방문하고 0번 index의 지역에 이틀간 방문하게 되는 것이다. 2번 index의 지역을 방문하기 위해서는
 * 사흘간 머물러야 하는데 그렇게 되면 total값의 일수를 초과하게 되므로 불가능하다. 결과적으로 여행 기간 동안 방문할 수 있는 최대
 * 지역의 개수는 2가 된다.
 * 
 * 
 * @author Yunho Lee
 * 
 */
public class FoxAndVacation {
	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 50;
	private static final int MIN_TOTAL_DAYS = 1;
	private static final int MAX_TOTAL_DAYS = 50;
	private static final int MIN_DAYS_LIST_SIZE = 1;
	private static final int MAX_DAYS_LIST_SIZE = 50;

	public int maxCities(int total, int[] d) {
		int totalDays = total;
		List<Integer> days = Arrays.asList(ArrayUtils.toObject(d));

		if (isValidInput(totalDays, days) == false)
			return -1;

		Collections.sort(days);

		return countVisitedCitiesNum(totalDays, days);
	}

	private int countVisitedCitiesNum(int totalDays, List<Integer> days) {
		int sumDays = 0;
		int visitedCitiesNum = 0;

		for (int index = 0; index < days.size(); index++) {
			sumDays += days.get(index);

			if (sumDays <= totalDays)
				visitedCitiesNum++;
		}

		return visitedCitiesNum;
	}

	private boolean isValidInput(int totalDays, List<Integer> days) {
		if (isValidTotalRange(totalDays) && isValidDaysRange(days) && isValidDayRange(days))
			return true;
		return false;
	}

	private boolean isValidTotalRange(int totalDays) {
		if (totalDays < MIN_TOTAL_DAYS || totalDays > MAX_TOTAL_DAYS)
			return false;
		return true;
	}

	private boolean isValidDaysRange(List<Integer> days) {
		if (days.size() < MIN_DAYS_LIST_SIZE || days.size() > MAX_DAYS_LIST_SIZE)
			return false;
		return true;
	}

	private boolean isValidDayRange(List<Integer> days) {
		for (int day : days)
			if (day < MIN_DAY || day > MAX_DAY)
				return false;
		return true;
	}

}
