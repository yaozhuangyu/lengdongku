package com.jkoss.tool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
	/**
	 * 閿熸枻鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹(閿熸枻鎷锋瘝)閿熸枻鎷烽敓鏂ゆ嫹浣嶉敓鏂ゆ嫹姣嶈浆涓洪敓鏂ゆ嫹鍐�
	 * 
	 * @param  
	 * @return
	 */
	public static final String regIDCode ="//";
	
	
	public static String getFirstUpper(String s) {
		if (s != null && s.length() > 0) {
			char charAt = s.charAt(0);
			if (charAt <= 'z' && charAt >= 'a') {
				charAt -= 32;
			}
			s = charAt + s.substring(1);

		}
		return s;
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹杞敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷�
	 * 
	 * @param Object
	 *            source
	 * @return
	 */
	public static String getNotNullString(Object source) {
		return source == null ? "" : source.toString(); //$NON-NLS-1$
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹杞敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷�
	 * 
	 * @param byte[] source
	 * @return
	 */
	public static String getNotNullString(byte[] source) {
		return source == null ? "" : new String(source); //$NON-NLS-1$
	}

	/**
	 * 鍒犻敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷峰墠閿熸枻鎷风洰宕敓锟�
	 * 
	 * @param source
	 * @return
	 */
	public static String getNotNullStringAndTrim(Object source) {
		return getNotNullString(source).trim();
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static String[] getNotNullStrings(String[] source) {
		String[] newStrin = new String[source.length];
		for (int i = 0; i < source.length; i++) {
			String string = source[i];
			newStrin[i] = getNotNullString(string);
		}
		return newStrin;
	}

	/**
	 * String杞琁nteger
	 * 
	 * @param source
	 * @return
	 */
	public static Integer getNotNullInteger(String source) {
		int i = 0;
		if (source != null && source.length() > 0) {
			try {
				i = Integer.parseInt(source);
			} catch (Exception e) {
				// do nothing.
			}
		}
		return i;
	}

	/**
	 * 閿熸枻鎷疯浆閿熸枻鎷稴tring閿熸枻鎷稩nteger 閿熸枻鎷稴tring涓簄ull閿熸枻鎷烽敓鏂ゆ嫹閿燂拷0
	 * 
	 * @param source
	 * @return
	 */
	public static String getNotNullIntegerStr(String source) {
		int i = 0;
		if (source != null && source.length() > 0) {
			try {
				i = Integer.parseInt(source);
			} catch (Exception e) {
				// do nothing.
			}
		}
		return "" + i; //$NON-NLS-1$
	}

	/**
	 * 閿熸枻鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹杞负boolean
	 * 
	 * @param bv
	 * @return
	 */
	public static Boolean getNotNullBoolean(String bv) {
		boolean bvb = false;
		if (bv != null && !bv.equals("")) { //$NON-NLS-1$
			try {
				bvb = Boolean.valueOf(bv).booleanValue();
			} catch (Exception e) {
				// do nothing.
			}
		}
		return bvb;
	}

	/**
	 * String閿熸枻鎷烽敓楗鸿揪鎷烽敓鏂ゆ嫹50閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�50閿熺殕鐚存嫹閿熸枻鎷峰潃閿熸枻鎷疯癌閿燂拷...閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	 * 
	 * @param s
	 * @return
	 */
	public static String getDotString(String s) {
		String dot = ""; //$NON-NLS-1$
		if (s.length() > 50) {
			dot = s.substring(0, 50);
			dot += "..."; //$NON-NLS-1$
		} else {
			dot = s;
		}
		return dot;
	}

	/**
	 * 鍙敓鍙柇纰夋嫹涓�浣嶉敓鏂ゆ嫹閿熻鐨勮揪鎷峰皬閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	 * 
	 * @param list
	 * @return
	 */
	public static String[] pasteSortedArray(Collection<String> list) {
		if (list != null) {
			String[] panels = new String[list.size()];
			int i = 0;
			for (Iterator<String> iterator = list.iterator(); iterator
					.hasNext();) {
				String string = (String) iterator.next();
				panels[i] = string;
				i++;
			}
			Arrays.sort(panels);
			return panels;
		} else {
			return new String[0];
		}
	}

	/**
	 * 閿熸枻鎷穝tr閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎺ョ鎷穕ength閿熸枻鎷蜂竴閿熸枻鎷烽敓渚ョ鎷烽敓楗猴綇鎷烽敓鑺傜尨鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�" "閿熺Ц鏍硷級锝忔嫹閿熸枻鎷烽敓绲猼r閿熶茎绛规嫹閿熼ズ鎲嬫嫹length閿熸枻鎷烽敓娲ヨ繑浼欐嫹str
	 * 
	 * @param str
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ鎷烽敓楗虹鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹
	 * @param length
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ殑绛规嫹閿熸枻鎷�
	 * @return
	 */
	public static String fillEndBlank(String str, int length) {
		int length2 = str.length();
		if (length > length2) {
			for (int i = 0; i < length - length2; i++) {
				str = str + " "; //$NON-NLS-1$
			}
		}
		return str;
	}

	/**
	 * 閿熸枻鎷穝tr閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎺ョ鎷穕ength閿熸枻鎷蜂竴閿熸枻鎷烽敓渚ョ鎷烽敓楗猴綇鎷烽敓鏂ゆ嫹鍓嶉敓鏂ゆ嫹閿熸枻鎷烽敓锟�" "閿熺Ц鏍硷級锝忔嫹閿熸枻鎷烽敓绲猼r閿熶茎绛规嫹閿熼ズ鎲嬫嫹length閿熸枻鎷烽敓娲ヨ繑浼欐嫹str
	 * 
	 * @param str
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ鎷烽敓楗虹鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹
	 * @param length
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ殑绛规嫹閿熸枻鎷�
	 * @return
	 */
	public static String fillStartBlank(String str, int length) {
		int length2 = str.length();
		if (length > length2) {
			for (int i = 0; i < length - length2; i++) {
				str = " " + str; //$NON-NLS-1$
			}
		}
		return str;
	}

	/**
	 * 閿熸枻鎷穝tr閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎺ョ鎷穕ength閿熸枻鎷蜂竴閿熸枻鎷烽敓渚ョ鎷烽敓楗猴綇鎷烽敓鏂ゆ嫹鍓嶉敓鏂ゆ嫹閿熸枻鎷烽敓绲氶敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熺氮tr閿熶茎绛规嫹閿熼ズ鎲嬫嫹length閿熸枻鎷烽敓娲ヨ繑浼欐嫹str
	 * 
	 * @param str
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ鎷烽敓楗虹鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹
	 * @param length
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ殑绛规嫹閿熸枻鎷�
	 * @return
	 */
	public static String fillStartBlank(String str, int length, char c) {
		int length2 = str.length();
		if (length > length2) {
			for (int i = 0; i < length - length2; i++) {
				str = c + str; //$NON-NLS-1$
			}
		}
		return str;
	}

	/**
	 * 閿熸枻鎷穝tr閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎺ョ鎷穕ength閿熸枻鎷蜂竴閿熸枻鎷烽敓渚ョ鎷烽敓楗猴綇鎷烽敓鑺傜尨鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓绲氶敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熺氮tr閿熶茎绛规嫹閿熼ズ鎲嬫嫹length閿熸枻鎷烽敓娲ヨ繑浼欐嫹str
	 * 
	 * @param str
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ鎷烽敓楗虹鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹
	 * @param length
	 *            閿熸枻鎷疯閿熸枻鎷烽敓鎺ョ殑绛规嫹閿熸枻鎷�
	 * @return
	 */
	public static String fillEndChar(String str, int length, char c) {
		int length2 = str.length();
		if (length > length2) {
			for (int i = 0; i < length - length2; i++) {
				str = str + c;
			}
		}
		return str;
	}

	/**
	 * StringBuffer閿熸枻鎷锋秾宕槩顑愰敓琛楅潻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	 * 
	 * @param str
	 * @param length
	 */
	public static void fillAfterBlank(StringBuffer str, int length) {
		int length2 = str.length();
		if (length > length2) {
			for (int i = 0; i < length - length2; i++) {
				str.append(" "); //$NON-NLS-1$
			}
		}
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熻闈╂嫹閿熸枻鎷烽敓鏂ゆ嫹楣婇敓鏂ゆ嫹閿熸枻鎷烽敓璇紙閿熸枻鎷峰皬鍐欓敓鏂ゆ嫹姣嶉敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰笇閿燂拷
	 * 
	 * @param length
	 * @return
	 */
	public static String getAsciiRandomString(int length) {
		Random random = new Random();
		int cnt = 0;
		StringBuffer buffer = new StringBuffer();
		char ch;
		int end = 'z' + 1;
		int start = ' ';
		while (cnt < length) {
			ch = (char) (random.nextInt(end - start) + start);
			if (Character.isLetterOrDigit(ch)) {
				buffer.append(ch);
				cnt++;
			}
		}
		return buffer.toString();
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹 String 閿熸枻鎷烽敓鏂ゆ嫹涓�閿熸枻鎷� String 閿熸枻鎷烽敓鍙瘮杈冿綇鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓瑙掕揪鎷峰皬鍐欓敓鏂ゆ嫹
	 * 
	 * @param list
	 * @param str
	 * @return
	 */
	public static boolean containIgnoreCase(Collection<String> list, String str) {
		for (String string : list) {
			if (string.trim().equalsIgnoreCase(str.trim())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 鍏ㄩ敓鏂ゆ嫹閿熸枻鎷锋瘝杞负閿熸枻鎷峰啓
	 * 
	 * @param s
	 * @return
	 */
	public static String formatFrom400(Object s) {
		if (s != null) {
			return s.toString().trim().toUpperCase();
		}
		return null;
	}

	/**
	 * 鍘婚敓鏂ゆ嫹鍓嶉敓鏂ゆ嫹宕敓瑗燂紝鏂ゆ嫹閿熸枻鎷� String 閿熸枻鎷烽敓鏂ゆ嫹涓�閿熸枻鎷� String 閿熸枻鎷烽敓鍙瘮杈冿綇鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓瑙掕揪鎷峰皬鍐欓敓鏂ゆ嫹
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equalsFrom400(String s1, String s2) {
		if (s1 != null) {
			if (s2 != null) {
				return s1.trim().equalsIgnoreCase(s2.trim());
			} else {
				return false;
			}
		} else {
			return s2 == null;
		}
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹 String 閿熸枻鎷烽敓鏂ゆ嫹涓�閿熸枻鎷� String 閿熸枻鎷烽敓鍙瘮杈冿綇鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓瑙掕揪鎷峰皬鍐欓敓鏂ゆ嫹
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equalsFrom(String s1, String s2) {
		if (s1 != null) {
			if (s2 != null) {
				return s1.equalsIgnoreCase(s2);
			} else {
				return false;
			}
		} else {
			return s2 == null;
		}
	}

	/**
	 * 閿熻鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷"''"
	 * 
	 * @param s
	 * @return
	 */
	public static String addSimpleQuote(String s) {
		if (!s.endsWith("'")) { //$NON-NLS-1$
			s = s + "'"; //$NON-NLS-1$
		}
		if (!s.startsWith("'")) { //$NON-NLS-1$
			s = "'" + s; //$NON-NLS-1$
		}
		return s;
	}

	// public static String getCurDate() {
	////        return DateFormatUtils.format(new Date(), "yyyyMMdd HH:mm:ss"); //$NON-NLS-1$
	// }

	// public static String getMemeberPath(AbsFile file, String absMember) {
	//        QSYSObjectPathName name = new QSYSObjectPathName(file.getLibrary().getName(), file.getName(), absMember, "MBR"); //$NON-NLS-1$
	// return name.getPath();
	// }
	/**
	 * 鍘婚敓鏂ゆ嫹鍓嶉敓鏂ゆ嫹宕敓鏂ゆ嫹閿熸枻鎷锋瘝杞负閿熸枻鎷峰啓
	 * 
	 * @param s
	 * @return
	 */
	public static String trimPrefix(String s) {

		int len = s.length();
		int st = 0;
		char[] val = s.toCharArray();

		while ((st < len) && (val[st] <= ' ')) {
			st++;
		}
		return ((st > 0) && (st < len)) ? s.substring(st, s.length())
				.toUpperCase() : s.toUpperCase();

	}

	public static String trimString(Object str) {
		if (str != null) {
			return trimSuffix(str.toString());
		}
		return null;
	}

	public static String trimStringDecimal(Object str) {
		if (str instanceof Date) {
			SimpleDateFormat iso0Format = new SimpleDateFormat("yyyyMMdd");
			return iso0Format.format((Date) str);
		}
		if (str != null) {
			if (str.toString().trim().length() > 0) {
				return trimSuffix(str.toString());
			} else {
				return "0";
			}
		}
		return null;
	}

	/**
	 * 鍘婚敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷风洰宕敓锟�
	 * 
	 * @param s
	 * @return
	 */
	public static String trimSuffix(String s) {

		int len = s.length();
		char[] val = s.toCharArray();
		while (len > 0 && (val[len - 1] <= ' ' || val[len - 1] == 'a')) {
			len--;
		}
		return ((len > 0) && len <= s.length()) ? s.substring(0, len) : s;
	}

	/**
	 * 閿熸枻鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹閿熸枻鎷风煡閿熸枻鎷烽敓鏂ゆ嫹閿熼ズ璇ф嫹娈栭敓鏂ゆ嫹鍧�閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	 * 
	 * @param rpgString
	 *            鎸囬敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷�
	 * @param perLength
	 *            鎸囬敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	 * @return
	 */
	public static List<String> splitRpgString(String rpgString, int perLength) {
		List<String> splitRpgList = new ArrayList<String>();

		if (rpgString != null && rpgString.length() > 0 && perLength > 0) {
			StringBuilder sb = new StringBuilder();
			int rpgLength = 0;
			boolean lastChar = false;
			char[] rpgChar = rpgString.toCharArray();
			for (int i = 0; i < rpgChar.length; i++) {
				char c = rpgChar[i];
				boolean isch = isChinese(c);
				if (isch) {
					rpgLength += 2;
				} else {
					rpgLength += 1;
				}
				if (lastChar != isch) {
					rpgLength += 1;
				}
				lastChar = isch;
				if (rpgLength <= perLength) {
					sb.append(c);
					if (i == rpgChar.length - 1) {
						splitRpgList.add(sb.toString());
					}
				} else {
					splitRpgList.add(sb.toString());
					rpgLength = 0;
					lastChar = false;
					sb = new StringBuilder();
					isch = isChinese(c);
					if (isch) {
						rpgLength += 2;
					} else {
						rpgLength += 1;
					}
					if (lastChar != isch) {
						rpgLength += 1;
					}
					lastChar = isch;
					if (rpgLength <= perLength) {
						sb.append(c);
					}
				}
			}
		}

		return splitRpgList;
	}

	/**
	 * 閿熸枻鎷锋寚閿熸枻鎷烽敓鏂ゆ嫹閿熼ズ鏂ゆ嫹鍙栭敓琛楀嚖鎷烽敓鏂ゆ嫹
	 * 
	 * @param rpgString
	 * @param length
	 * @return
	 */
	public static String subRpgString(String rpgString, int length) {
		StringBuilder sb = new StringBuilder();
		if (rpgString != null && rpgString.length() > 0 && length > 0) {
			int rpgLength = 0;
			boolean lastChar = false;
			char[] rpgChar = rpgString.toCharArray();
			for (int i = 0; i < rpgChar.length; i++) {
				char c = rpgChar[i];
				boolean isch = isChinese(c);
				if (isch) {
					rpgLength += 2;
				} else {
					rpgLength += 1;
				}
				if (lastChar != isch) {
					rpgLength += 1;
				}
				lastChar = isch;
				if (rpgLength < length) {
					sb.append(c);
				} else if (rpgLength == length) {
					if (isch) {
						break;
					} else {
						sb.append(c);
					}
				} else {
					break;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹, 閿熸枻鎷烽敓鏂ゆ嫹閿熸彮浼欐嫹閿熸枻鎷峰潃閿熻娇顏庢嫹閿熸枻鎷烽敓锟�, 閿熸枻鎷烽敓楗虹》鎷�1, 閿熸枻鎷烽敓渚ョ尨鎷疯嫳閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋椂, 閿熸枻鎷烽敓楗虹》鎷�1
	 * 
	 * @param rpgString
	 * @return
	 */
	public static int countRpgLength(String rpgString) {
		int rpgLength = 0;

		if (rpgString != null && rpgString.length() > 0) {
			boolean lastChar = false;
			char[] rpgChar = rpgString.toCharArray();
			for (int i = 0; i < rpgChar.length; i++) {
				boolean isch = isChinese(rpgChar[i]);
				if (isch) {
					rpgLength += 2;
				} else {
					rpgLength += 1;
				}
				if (lastChar != isch) {
					rpgLength += 1;
				}
				lastChar = isch;
			}
		}

		return rpgLength;
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹, 閿熸枻鎷烽敓鏂ゆ嫹閿熸彮浼欐嫹閿熸枻鎷峰潃閿熻娇顏庢嫹閿熸枻鎷烽敓锟�, 閿熸枻鎷烽敓楗虹》鎷�1, 閿熸枻鎷烽敓渚ョ尨鎷疯嫳閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋椂, 閿熸枻鎷烽敓楗虹》鎷�1, 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷蜂竴閿熸枻鎷烽敓琛楀嚖鎷�, 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷, 閿熸枻鎷烽敓楗烘枻鎷烽敓鏂ゆ嫹1
	 * 
	 * @param rpgString
	 * @return
	 */
	public static int countRpgLengthCheckLastChar(String rpgString) {
		int rpgLength = 0;

		if (rpgString != null && rpgString.length() > 0) {
			boolean lastChar = false;
			char[] rpgChar = rpgString.toCharArray();
			int sLength = rpgChar.length;
			for (int i = 0; i < sLength; i++) {
				boolean isch = isChinese(rpgChar[i]);
				if (isch) {
					rpgLength += 2;
				} else {
					rpgLength += 1;
				}
				if (lastChar != isch) {
					rpgLength += 1;
				}
				lastChar = isch;
			}
			if (isChinese(rpgChar[sLength - 1])) {
				rpgLength += 1;
			}
		}

		return rpgLength;
	}

	/**
	 * 閿熸枻鎷疯嫳閿熶茎鐚存嫹閿熸枻鎷烽敓鏂ゆ嫹涔嬮敓鏂ゆ嫹閿熼ズ銉掍紮鎷烽敓鏂ゆ嫹宕敓锟�
	 * 
	 * @param content
	 * @return
	 */
	public static String cutRpgContent(String content) {
		StringBuilder sb = new StringBuilder();
		if (content != null && content.length() > 0) {
			boolean lastChar = false;
			char[] rpgChar = content.toCharArray();
			int sLength = rpgChar.length;
			for (int i = 0; i < sLength; i++) {
				char c = rpgChar[i];
				boolean isch = isChinese(c);
				if (lastChar != isch) {
					if (isch) {
						if ((i - 1) >= 0 && rpgChar[i - 1] == ' ') {
							sb.setCharAt((sb.length() - 1), c);
						} else {
							sb.append(c);
						}
					} else {
						if (rpgChar[i] != ' ') {
							sb.append(c);
						}
					}
				} else {
					sb.append(c);
				}
				lastChar = isch;
			}
		}

		return sb.toString();
	}

	/**
	 * 閿熸枻鎷疯嫳閿熶茎鐚存嫹閿熸枻鎷烽敓鏂ゆ嫹涔嬮敓鏂ゆ嫹閿熸枻鎷烽敓鎻紮鎷烽敓鏂ゆ嫹宕敓鏂ゆ嫹鍧�閿燂拷
	 * 
	 * @param content
	 * @return
	 */
	public static String processRpgContent(String content) {
		StringBuilder sb = new StringBuilder();
		if (content != null && content.length() > 0) {
			boolean lastChar = false;
			char[] rpgChar = content.toCharArray();
			int sLength = rpgChar.length;
			for (int i = 0; i < sLength; i++) {
				boolean isch = isChinese(rpgChar[i]);
				if (lastChar != isch) {
					sb.append(' ');
				}
				sb.append(rpgChar[i]);
				lastChar = isch;
			}
		}

		return sb.toString();
	}

	/**
	 * 閿熷彨璁规嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓瑙掑嚖鎷烽敓鏂ゆ嫹true
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 閿熷彨璁规嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓瑙掑嚖鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻鍑ゆ嫹
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	public static String cutStringTrimByLength(String source, int length) {
		if (source == null || length <= 0) {
			return "";
		}

		if (source.length() <= length) {
			return source;
		}

		return source.substring(0, length);
	}

	/**
	 * 閿熷彨璁规嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋瑺閿熻娇顏庢嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isDigital(String s) {
		Pattern pattern = Pattern.compile("[0-9]|[0-9][0-9]*");
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}

	/**
	 * 閿熸枻鎷�1閿熸枻鎷峰
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isDigitalFromOne(String s) {
		Pattern pattern = Pattern.compile("[1-9]|[1-9][0-9]*");
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}

	/**
	 * 閿熷彨璁规嫹string閿熻鍑ゆ嫹閿熸枻鎷稴tring[] ss閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	 * 
	 * @param string
	 * @param ss
	 * @return
	 */
	public static boolean isAmongArrays(String string, String[] ss) {
		if (string != null && ss != null && ss.length > 0) {
			boolean in = false;
			for (String s : ss) {
				if (string.trim().equalsIgnoreCase(s)) {
					in = true;
				}
			}
			return in;
		}
		return true;
	}

	/**
	 * 閿熸枻鎷峰彇鎸囬敓鏂ゆ嫹閿熻鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鎸囬敓鏂ゆ嫹閿熸枻鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹閿熺殕鐚存嫹閿熸枻鎷峰潃閿熺即鎾呮嫹閿燂拷
	 * 
	 * @param name
	 * @param divide
	 * @return
	 */
	public static String removeLastDecLine(String name, String divide) {
		if (name.contains(divide)) {
			int lastDec = name.lastIndexOf(divide);

			return name.substring(0, lastDec);
		}

		return name;
	}

	public static void main(String[] args) {
		// QSYSObjectPathName name = new
		// QSYSObjectPathName("/QSYS.LIB/ZQLIB.LIB/ZQSRC1.FILE/TSTMBR.MBR");
		// System.out.println(name.getPath());
		// System.out.println("F:" + trimSuffix(" w  ") + ":");
		String s = "2012-08-31-00.00.00.000000";
		System.out.println("s[" + s.substring(0, 10) + " "
				+ s.substring(11, 13) + ":" + s.substring(14, 16) + ":"
				+ s.substring(17, 19) + ":" + s.substring(20) + "]");

	}

}
