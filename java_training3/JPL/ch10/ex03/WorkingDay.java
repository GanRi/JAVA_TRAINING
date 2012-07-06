package ch10.ex03;

import ch06.ex01.WeekDay;

public class WorkingDay {
	public boolean isWorkingDay1(WeekDay day){
		if (day == WeekDay.Mon || day == WeekDay.Tues || day == WeekDay.Wed ||
				day == WeekDay.Thur || day == WeekDay.Fri){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isWorkingDay2(WeekDay day){
		boolean result = false;
		
		switch(day){
		case Mon:
		case Tues:
		case Wed:
		case Thur:
		case Fri:
			result = true;
			break;
		case Sat:
		case Sun:
			result = false;
		}
		
		return result;
	}
	
	
	public static void main(String[] args){
		WorkingDay workingDay = new WorkingDay();
		System.out.println(workingDay.isWorkingDay1(WeekDay.Mon));
		System.out.println(workingDay.isWorkingDay1(WeekDay.Fri));
		System.out.println(workingDay.isWorkingDay1(WeekDay.Sat));
		
		System.out.println(workingDay.isWorkingDay2(WeekDay.Mon));
		System.out.println(workingDay.isWorkingDay2(WeekDay.Fri));
		System.out.println(workingDay.isWorkingDay2(WeekDay.Sat));		
	}

}
