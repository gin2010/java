package demo21;

//NextDate�������ִ���
public class NextDate {
	/** �� */
	private int year;
	/** �� */
	private int month;
	/** �� */
	private int day;

	/**
	 * ���췽��
	 * 
	 * @param year
	 *            ��month��day:�ꡢ�¡���;
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
	 * �����
	 * 
	 * @return �����
	 */
	public int getyear() {
		return this.year;
	}

	/**
	 * ����·�
	 * 
	 * @return ����·�
	 */
	public int getmonth() {
		return this.month;
	}

	/**
	 * �������
	 * 
	 * @return �������
	 */
	public int getday() {
		return this.day;
	}

	/**
	 * �ж�����
	 * 
	 * @return �Ƿ�����
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
	 * ���㵱ǰ���ڵ���һ��
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
	 * ������һ��
	 * 
	 * @return ��һ�������
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
	 * �ж������Ƿ���Ч
	 * 
	 * @return �Ƿ���Ч
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