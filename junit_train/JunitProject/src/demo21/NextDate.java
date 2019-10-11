package demo21;

//NextDate函数部分代码
public class NextDate {
	/** 年 */
	private int year;
	/** 月 */
	private int month;
	/** 日 */
	private int day;

	/**
	 * 构造方法
	 * 
	 * @param year
	 *            、month、day:年、月、日;
	 */

	public NextDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public NextDate() {
		year = 1;
		month = 1;
		day = 1;
	}

	/**
	 * 获得年
	 * 
	 * @return 获得年
	 */
	public int getyear() {
		return this.year;
	}

	/**
	 * 获得月份
	 * 
	 * @return 获得月份
	 */
	public int getmonth() {
		return this.month;
	}

	/**
	 * 获得日期
	 * 
	 * @return 获得日期
	 */
	public int getday() {
		return this.day;
	}

	/**
	 * 判断闰年
	 * 
	 * @return 是否闰年
	 */
	public boolean isleap() {
		if ((this.year % 4 == 0 && this.year % 100 != 0)
				|| (this.year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 计算当前日期的下一天
	 */
	public void nextday() {
		switch (this.month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (this.day == 31) {
				this.month = this.month + 1;
				this.day = 1;
			} else {
				this.day = this.day + 1;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (this.day == 30) {
				this.month = this.month + 1;
				this.day = 1;
			} else {
				this.day = this.day + 1;
			}
			break;
		case 12:
			if (this.day == 31) {
				this.month = 1;
				this.day = 1;
				this.year = this.year + 1;
			} else {
				this.day = this.day + 1;
			}
			break;
		case 2:
			if (this.isleap()) {
				if (this.day == 29) {
					this.day = 1;
					this.month = 3;
				} else {
					this.day = this.day + 1;
				}
			} else {
				if (this.day == 28) {
					this.day = 1;
					this.month = 3;
				} else {
					this.day = this.day + 1;
				}
			}
			break;
		}
	}

	/**
	 * 计算下一天
	 * 
	 * @return 下一天的日期
	 */
	public NextDate nextday(NextDate date) {
		switch (date.month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (date.day == 31) {
				date.month = date.month + 1;
				date.day = 1;
			} else {
				date.day = date.day + 1;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (date.day == 30) {
				date.month = date.month + 1;
				date.day = 1;
			} else {
				date.day = date.day + 1;
			}
			break;
		case 12:
			if (date.day == 31) {
				date.month = 1;
				date.day = 1;
				date.year = date.year + 1;
			} else {
				date.day = date.day + 1;
			}
			break;
		case 2:
			if (date.isleap()) {
				if (date.day == 29) {
					date.day = 1;
					date.month = 3;
				} else {
					date.day = date.day + 1;
				}
			} else {
				if (date.day == 28) {
					date.day = 1;
					date.month = 3;
				} else {
					date.day = date.day + 1;
				}
			}
			break;
		}
		return date;
	}

	/**
	 * 判断日期是否有效
	 * 
	 * @return 是否有效
	 */
	public boolean isDate(NextDate date) {
		boolean flag = true;
		if ((date.year < 0) || (date.year > 2050)) {
			flag = false;
		}
		if ((date.month < 1) || (date.month > 12)) {
			flag = false;
		} else {
			switch (date.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if ((date.day > 31) || (date.day < 1))
					flag = false;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if ((date.day > 30) || (date.day < 1)) {
					flag = false;
				}
				break;
			case 2:
				if (date.isleap()) {
					if ((date.day > 29) || (date.day < 1))
						flag = false;
				} else {
					if ((date.day > 28) || (date.day < 1))
						flag = false;
				}
				break;
			}
		}
		return flag;
	}

	@Override
	public String toString() {
		return " [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
}