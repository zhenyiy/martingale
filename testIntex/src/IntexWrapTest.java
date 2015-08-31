import com.intex.IntexWrap;
import com.intex.IntexWrapException;
import com.intex.IntexWrapParseException;
import com.intex.KeyVal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IntexWrapTest {
	static {
		System.setProperty("LD_LIBRARY_PATH", "/vn_le/en2_data_d/intex/test_intex/testIntex2/src");
		System.setProperty("java.library.path", "/vn_le/en2_data_d/intex/test_intex/testIntex2");
		System.loadLibrary("IntexWrapJNI"); // Notice lack of lib
		System.loadLibrary("vcmowrap"); // Notice lack of lib prefix
	}

	private static String CDI_PATH() {
		if (System.getProperty("file.separator").equals("/"))
			return "/vn_cont/intexprod/data/cdi";
/*			return "/vn_le/en2_data_d/intex/cdi";
*/			return "s:\\cmo_cdi";
	}

	private static String CDU_PATH() {
		if (System.getProperty("file.separator").equals("/"))
			return "/vn_cont/intexprod/data/cdu";
/*			return "/vn_le/en2_data_d/intex/cdu";
*/		return "s:\\cmo_cdu";
	}

	public static void main(String args[]) {

		try {
			StringBuffer DataOut = new StringBuffer("");
			String accessCode = "tbvskobcg1trnufl1";
			String companyName = "FANNIE MAE - PORTFOLIO INVESTMENTS/CHIEF RISK-FINANCIAL OFFICE";
			String dealName = "ctas14c2";
			String[] trancheNames = { "'1M1'", "'2M1'",/*"'M1H'", "'M2'", "'M2H'", "'BH'",*/ "'COLLAT'" };
			String prepayCurve = "0 0.413567 0.439834 0.484839 0.520379 0.542872 0.501661 0.423173 0.419536 0.342323 0.364537 0.259933 0.306081 0.394748 0.383111 0.401545 0.469375 0.505753 0.523456 0.573886 0.556062 0.465811 0.41732 0.273265 0.37301 0.541096 0.550156 0.727909 0.911615 1.123303 1.344761 1.086223 1.075762 1.050548 1.064823 1.15621 1.048812 0.982148 0.723533 0.704106 0.74498 0.618754 0.51607 0.364692 0.381706 0.353633 0.330844 0.32059 0.327148 0.353728 0.320223 0.367187 0.354411 0.310803 0.271863 0.175938 0.176157 0.151086 0.136205 0.108117 0.129835 0.166407 0.176961 0.205678 0.193345 0.20776 0.202659 0.163073 0.175747 0.166413 0.1842 0.151368 0.163698 0.215089 0.238619 0.277383 0.342215 0.360674 0.361099 0.342983 0.375802 0.341103 0.317633 0.215797 0.24998 0.345071 0.342615 0.359396 0.442659 0.516543 0.654182 0.56427 0.48784 0.40601 0.342321 0.218508 0.285683 0.404975 0.376023 0.447634 0.510296 0.463409 0.525377 0.411172 0.377455 0.358868 0.324048 0.232708 0.30287 0.434411 0.3828 0.50118 0.545042 0.488472 0.549376 0.410594 0.413208 0.376894 0.328203 0.262999 0.338818 0.45188 0.486507 0.575505 0.56366 0.607128 0.588071 0.458618 0.486749 0.407939 0.391503 0.295347 0.366671 0.488807 0.534024 0.606691 0.65283 0.672286 0.626177 0.536453 0.549012 0.439787 0.458257 0.316083 0.407808 0.549628 0.547039 0.579667 0.67062 0.644284 0.601419 0.518573 0.502117 0.438736 0.435249 0.28262 0.385031 0.552557 0.533534 0.571638 0.672202 0.625354 0.635256 0.513407 0.468265 0.443423 0.420007 0.277676 0.386803 0.552768 0.498707 0.656881 0.704051 0.621136 0.696972 0.512869 0.50864 0.464152 0.398717 0.319673 0.40772 0.57304 0.555489 0.668321 0.672287 0.649403 0.687349 0.482845 0.529124 0.458323 0.394603 0.312996 0.391263 0.517631 0.55298 0.654935 0.644081 0.689088 0.670568 0.517458 0.54013 0.446543 0.423716 0.321274 0.401152 0.530951 0.567509 0.643075 0.69591 0.715847 0.675327 0.57657 0.58074 0.458049 0.476 0.334672 0.426466 0.643212 0.638296 0.708549 0.861739 0.81193 0.843085 0.698971 0.643681 0.617532 0.596964 0.395845 0.538503 0.775518 0.729893 0.868513 0.978702 0.880207 0.987536 0.770979 0.70811 0.670947 0.60991 0.449344 0.584079 0.837938 0.745317 0.964025 1.029909 0.907389 0.989792 0.717406 0.706556 0.63268 0.539248 0.423863 0.528839 0.738859 0.724205 0.906118 0.958252 0.967751 1.059553 0.759014 0.833104 0.728447 0.635577 0.509326 0.637416 0.813223 0.85983 0.959832 1.011879 1.00792 0.926476 0.776873 0.766585 0.598123 0.613653 0.416054 0.531486 0.713806 0.711546 0.758517 0.893996 0.874811 0.81532 0.688819 0.656608 0.56704 0.562579 0.371386 0.512791 0.742606 0.72931 0.790939 0.937527 0.878254 0.897144 0.728491 0.667342 0.633459 0.601698 0.397949 0.548889 0.796331 0.747481 0.891894 1.010618 0.904975 1.013049 0.789651 0.724805 0.689455 0.626447 0.455764 0.610051 0.838681 0.823924 1.031161 1.071644 1.055206 1.131105 0.803784 0.890056 0.778987 0.678511 0.544788 0.689903 0.924956 1.002108 1.204791 1.203588 1.309408 1.297296 1.020646 1.087489 0.917892 0.881316 0.669428 0.836374 1.104587 1.177723 1.331235 1.43167 1.458063 1.353353 1.140431 1.125461 0.870446 0";
			String lossCurve = "0 0.001271 0.001331 0.001428 0.001533 0.001648 0.001962 0.00233 0.002736 0.00317 0.003603 0.004061 0.004443 0.004832 0.005256 0.005785 0.006367 0.007013 0.009406 0.014083 0.018505 0.02397 0.029529 0.035608 0.042273 0.050093 0.058202 0.068012 0.079531 0.096939 0.116743 0.141359 0.168268 0.204225 0.24807 0.296531 0.331024 0.368033 0.382722 0.395286 0.406505 0.426692 0.43497 0.442848 0.406973 0.373998 0.342773 0.307247 0.287569 0.268802 0.238948 0.213747 0.190754 0.168729 0.15345 0.138853 0.143893 0.146999 0.146889 0.149151 0.144233 0.13946 0.15244 0.160459 0.168756 0.177978 0.192687 0.208462 0.206179 0.194917 0.184177 0.171791 0.157925 0.145004 0.138627 0.133354 0.128194 0.11071 0.086877 0.064894 0.049 0.039818 0.032304 0.026502 0.023467 0.022522 0.022572 0.022705 0.022824 0.022945 0.023898 0.024941 0.026043 0.026041 0.026047 0.026063 0.025906 0.025727 0.025584 0.025443 0.025304 0.025194 0.024956 0.024767 0.024562 0.024259 0.023969 0.023702 0.023562 0.023409 0.023303 0.023322 0.023358 0.023418 0.023399 0.023428 0.023425 0.023318 0.023217 0.023124 0.023049 0.022966 0.022902 0.022884 0.02289 0.022882 0.022857 0.022859 0.022825 0.022709 0.022581 0.022475 0.02238 0.022273 0.022184 0.022148 0.022118 0.022093 0.022041 0.021999 0.021935 0.021796 0.02163 0.021502 0.021346 0.021181 0.021048 0.020936 0.020812 0.020713 0.020604 0.020504 0.020392 0.020208 0.020015 0.019856 0.019683 0.019497 0.01935 0.019239 0.019115 0.019021 0.018904 0.018814 0.01871 0.018549 0.01839 0.018257 0.018118 0.01797 0.017863 0.017754 0.017665 0.0176 0.017493 0.017434 0.017345 0.017211 0.017084 0.016961 0.01684 0.016706 0.016605 0.016512 0.016438 0.01637 0.016279 0.01623 0.016139 0.016018 0.015896 0.015779 0.015658 0.01553 0.015417 0.015324 0.015247 0.015163 0.015084 0.015026 0.014943 0.01484 0.014727 0.014628 0.014529 0.014423 0.014331 0.014263 0.014198 0.014138 0.01408 0.014032 0.013969 0.013887 0.013785 0.013706 0.013622 0.013519 0.013447 0.013394 0.013329 0.013292 0.013235 0.013203 0.013159 0.013068 0.012975 0.012907 0.012818 0.012715 0.012648 0.012588 0.012531 0.012501 0.012436 0.012412 0.01237 0.012278 0.012187 0.012109 0.012023 0.011922 0.011864 0.011801 0.011755 0.011733 0.011674 0.011659 0.011613 0.011527 0.011444 0.011366 0.011286 0.011193 0.011127 0.011066 0.011019 0.010976 0.010912 0.010893 0.010833 0.010748 0.010663 0.010583 0.010498 0.010409 0.010334 0.010278 0.010228 0.010184 0.01014 0.010103 0.010053 0.009982 0.009892 0.009825 0.00975 0.009667 0.009604 0.009561 0.009509 0.009472 0.009432 0.009399 0.009358 0.009287 0.009209 0.009149 0.009079 0.009001 0.008945 0.008906 0.008859 0.00883 0.008787 0.008761 0.008726 0.008654 0.008581 0.008523 0.008454 0.008377 0.008326 0.00828 0.008237 0.008212 0.008162 0.008139 0.008103 0.008031 0.00796 0.007898 0.007829 0.007754 0.007699 0.007648 0.007611 0.007577 0.00753 0.007513 0.007465 0.007397 0.007328 0.007262 0.007195 0.007121 0.00706 0.007011 0.006978 0.006937 0.006897 0.006876 0.006832 0.006771 0.006703 0.006647 0.006584 0.006515 0.00646 0.006422 0.006388 0.00636 0.006338 0.006337 0.00642 0.007343 0.009047";
			String prepayCurve1 = "0 0.413567 0.439834 0.484839 0.520379 0.542872 0.501661 0.423173 0.419536 0.342323 0.364537 0.259933 0.306081 0.394748 0.383111 0.401545 0.469375 0.505753 0.523456 0.573886 0.556062 0.465811 0.41732 0.273265 0.37301 0.541096 0.550156 0.727909 0.911615 1.123303 1.344761 1.086223 1.075762 1.050548 1.064823 1.15621 1.048812 0.982148 0.723533 0.704106 0.74498 0.618754 0.51607 0.364692 0.381706 0.353633 0.330844 0.32059 0.327148 0.353728 0.320223 0.367187 0.354411 0.310803 0.271863 0.175938 0.176157 0.151086 0.136205 0.108117 0.129835 0.166407 0.176961 0.205678 0.193345 0.20776 0.202659 0.163073 0.175747 0.166413 0.1842 0.151368 0.163698 0.215089 0.238619 0.277383 0.342215 0.360674 0.361099 0.342983 0.375802 0.341103 0.317633 0.215797 0.24998 0.345071 0.342615 0.359396 0.442659 0.516543 0.654182 0.56427 0.48784 0.40601 0.342321 0.218508 0.285683 0.404975 0.376023 0.447634 0.510296 0.463409 0.525377 0.411172 0.377455 0.358868 0.324048 0.232708 0.30287 0.434411 0.3828 0.50118 0.545042 0.488472 0.549376 0.410594 0.413208 0.376894 0.328203 0.262999 0.338818 0.45188 0.486507 0.575505 0.56366 0.607128 0.588071 0.458618 0.486749 0.407939 0.391503 0.295347 0.366671 0.488807 0.534024 0.606691 0.65283 0.672286 0.626177 0.536453 0.549012 0.439787 0.458257 0.316083 0.407808 0.549628 0.547039 0.579667 0.67062 0.644284 0.601419 0.518573 0.502117 0.438736 0.435249 0.28262 0.385031 0.552557 0.533534 0.571638 0.672202 0.625354 0.635256 0.513407 0.468265 0.443423 0.420007 0.277676 0.386803 0.552768 0.498707 0.656881 0.704051 0.621136 0.696972 0.512869 0.50864 0.464152 0.398717 0.319673 0.40772 0.57304 0.555489 0.668321 0.672287 0.649403 0.687349 0.482845 0.529124 0.458323 0.394603 0.312996 0.391263 0.517631 0.55298 0.654935 0.644081 0.689088 0.670568 0.517458 0.54013 0.446543 0.423716 0.321274 0.401152 0.530951 0.567509 0.643075 0.69591 0.715847 0.675327 0.57657 0.58074 0.458049 0.476 0.334672 0.426466 0.643212 0.638296 0.708549 0.861739 0.81193 0.843085 0.698971 0.643681 0.617532 0.596964 0.395845 0.538503 0.775518 0.729893 0.868513 0.978702 0.880207 0.987536 0.770979 0.70811 0.670947 0.60991 0.449344 0.584079 0.837938 0.745317 0.964025 1.029909 0.907389 0.989792 0.717406 0.706556 0.63268 0.539248 0.423863 0.528839 0.738859 0.724205 0.906118 0.958252 0.967751 1.059553 0.759014 0.833104 0.728447 0.635577 0.509326 0.637416 0.813223 0.85983 0.959832 1.011879 1.00792 0.926476 0.776873 0.766585 0.598123 0.613653 0.416054 0.531486 0.713806 0.711546 0.758517 0.893996 0.874811 0.81532 0.688819 0.656608 0.56704 0.562579 0.371386 0.512791 0.742606 0.72931 0.790939 0.937527 0.878254 0.897144 0.728491 0.667342 0.633459 0.601698 0.397949 0.548889 0.796331 0.747481 0.891894 1.010618 0.904975 1.013049 0.789651 0.724805 0.689455 0.626447 0.455764 0.610051 0.838681 0.823924 1.031161 1.071644 1.055206 1.131105 0.803784 0.890056 0.778987 0.678511 0.544788 0.689903 0.924956 1.002108 1.204791 1.203588 1.309408 1.297296 1.020646 1.087489 0.917892 0.881316 0.669428 0.836374 1.104587 1.177723 1.331235 1.43167 1.458063 1.353353 1.140431 1.125461 0.870446 0";
			String lossCurve1 = "0 0.001271 0.001331 0.001428 0.001533 0.001648 0.001962 0.00233 0.002736 0.00317 0.003603 0.004061 0.004443 0.004832 0.005256 0.005785 0.006367 0.007013 0.009406 0.014083 0.018505 0.02397 0.029529 0.035608 0.042273 0.050093 0.058202 0.068012 0.079531 0.096939 0.116743 0.141359 0.168268 0.204225 0.24807 0.296531 0.331024 0.368033 0.382722 0.395286 0.406505 0.426692 0.43497 0.442848 0.406973 0.373998 0.342773 0.307247 0.287569 0.268802 0.238948 0.213747 0.190754 0.168729 0.15345 0.138853 0.143893 0.146999 0.146889 0.149151 0.144233 0.13946 0.15244 0.160459 0.168756 0.177978 0.192687 0.208462 0.206179 0.194917 0.184177 0.171791 0.157925 0.145004 0.138627 0.133354 0.128194 0.11071 0.086877 0.064894 0.049 0.039818 0.032304 0.026502 0.023467 0.022522 0.022572 0.022705 0.022824 0.022945 0.023898 0.024941 0.026043 0.026041 0.026047 0.026063 0.025906 0.025727 0.025584 0.025443 0.025304 0.025194 0.024956 0.024767 0.024562 0.024259 0.023969 0.023702 0.023562 0.023409 0.023303 0.023322 0.023358 0.023418 0.023399 0.023428 0.023425 0.023318 0.023217 0.023124 0.023049 0.022966 0.022902 0.022884 0.02289 0.022882 0.022857 0.022859 0.022825 0.022709 0.022581 0.022475 0.02238 0.022273 0.022184 0.022148 0.022118 0.022093 0.022041 0.021999 0.021935 0.021796 0.02163 0.021502 0.021346 0.021181 0.021048 0.020936 0.020812 0.020713 0.020604 0.020504 0.020392 0.020208 0.020015 0.019856 0.019683 0.019497 0.01935 0.019239 0.019115 0.019021 0.018904 0.018814 0.01871 0.018549 0.01839 0.018257 0.018118 0.01797 0.017863 0.017754 0.017665 0.0176 0.017493 0.017434 0.017345 0.017211 0.017084 0.016961 0.01684 0.016706 0.016605 0.016512 0.016438 0.01637 0.016279 0.01623 0.016139 0.016018 0.015896 0.015779 0.015658 0.01553 0.015417 0.015324 0.015247 0.015163 0.015084 0.015026 0.014943 0.01484 0.014727 0.014628 0.014529 0.014423 0.014331 0.014263 0.014198 0.014138 0.01408 0.014032 0.013969 0.013887 0.013785 0.013706 0.013622 0.013519 0.013447 0.013394 0.013329 0.013292 0.013235 0.013203 0.013159 0.013068 0.012975 0.012907 0.012818 0.012715 0.012648 0.012588 0.012531 0.012501 0.012436 0.012412 0.01237 0.012278 0.012187 0.012109 0.012023 0.011922 0.011864 0.011801 0.011755 0.011733 0.011674 0.011659 0.011613 0.011527 0.011444 0.011366 0.011286 0.011193 0.011127 0.011066 0.011019 0.010976 0.010912 0.010893 0.010833 0.010748 0.010663 0.010583 0.010498 0.010409 0.010334 0.010278 0.010228 0.010184 0.01014 0.010103 0.010053 0.009982 0.009892 0.009825 0.00975 0.009667 0.009604 0.009561 0.009509 0.009472 0.009432 0.009399 0.009358 0.009287 0.009209 0.009149 0.009079 0.009001 0.008945 0.008906 0.008859 0.00883 0.008787 0.008761 0.008726 0.008654 0.008581 0.008523 0.008454 0.008377 0.008326 0.00828 0.008237 0.008212 0.008162 0.008139 0.008103 0.008031 0.00796 0.007898 0.007829 0.007754 0.007699 0.007648 0.007611 0.007577 0.00753 0.007513 0.007465 0.007397 0.007328 0.007262 0.007195 0.007121 0.00706 0.007011 0.006978 0.006937 0.006897 0.006876 0.006832 0.006771 0.006703 0.006647 0.006584 0.006515 0.00646 0.006422 0.006388 0.00636 0.006338 0.006337 0.00642 0.007343 0.009047";
			String prepayCurve2 = "1";
			String lossCurve2 = "1";
			
			String severityCurve = "0 20.55620842 21.4938096 22.47987991 22.57686578 22.98747908 23.41834176 23.85094295 24.27878698 25.1896413 26.08075941 27.05971293 28.09540784 29.21227735 30.50282615 31.62261521 32.68083841 33.79008694 35.19748708 36.61528665 37.96221751 39.49319775 41.02180527 42.39704255 43.87206814 45.34377867 46.18996328 46.60907692 47.05134353 47.54082579 48.11362998 48.66644169 49.3325093 49.92978898 50.39999489 50.65504513 50.99733195 51.31508287 51.62059072 52.04688909 52.53111577 52.95648771 53.4856676 53.89626527 54.33049626 54.90260274 55.15088602 55.42283223 55.76426684 56.10053574 56.47427016 57.13476269 57.76615148 58.42727319 58.60903213 58.74631092 58.91091053 58.66694148 58.33851003 56.60711859 55.88680116 55.1660123 54.32021709 53.53781782 52.74911978 51.90035613 51.28793621 50.26522461 49.53588028 49.67831908 49.81537332 49.92509835 50.03908417 50.12645378 50.21935629 50.10314819 49.9716871 50.14442044 49.71881714 49.15939176 48.87523495 48.75469929 48.57127114 48.309364 48.54151982 48.77393575 48.87905786 48.83083346 48.78938252 48.78265654 48.22170395 47.64978723 47.15331118 46.94828247 46.73267703 46.46364433 46.78196022 47.10327159 47.30151278 47.26008848 47.21930689 47.26126527 46.66364934 46.04364552 45.45878894 45.0553324 44.58220767 44.04197066 44.08543483 44.12805282 44.05353305 43.7380797 43.42275423 43.1725101 42.26639297 41.35223255 40.52282761 40.0189967 39.50904525 38.95119568 38.98823237 39.02339768 38.95599355 38.624583 38.29291752 37.99693255 37.05495625 36.08694761 35.20553748 34.64050366 34.0755391 33.46977181 33.4477657 33.42706744 33.30528147 32.93150236 32.55865963 32.22594196 31.20284909 30.17480261 29.2396626 28.61985132 27.99587562 27.35000314 27.34834704 27.44580745 27.47409437 27.25293218 27.02929427 26.83544233 25.96639062 25.09082348 24.32660464 23.89015801 23.44045782 22.97923225 23.10516303 23.25488066 23.28135099 23.04960556 22.82218639 22.63947135 21.78609609 20.92582326 20.22364071 19.8656915 19.52362218 19.14031523 19.38917173 19.64849899 19.75294906 19.56236841 19.37061563 19.21741654 18.37445613 17.53601559 16.89976834 16.60731407 16.33379712 16.01345863 16.36666158 16.74757974 16.93861776 16.83093303 16.72787732 16.68040761 15.94458003 15.21629944 14.75743566 14.64287541 14.54082849 14.35961809 14.87264128 15.39573815 15.66242986 15.6144567 15.55979174 15.58064438 14.92631432 14.28476477 13.96966109 13.97936969 13.9898849 13.89917181 14.46159224 15.02070698 15.26715735 15.20111514 15.12539902 15.15183879 14.56597242 13.96731108 13.75387426 13.80546637 13.87670119 13.82078624 14.37347278 14.92106116 15.10429812 14.99597159 14.88064072 14.9458279 14.40881144 13.86952382 13.7547462 13.90867344 14.05351438 14.04084527 14.57941105 15.11732953 15.22686887 15.06941237 14.90248366 14.89284203 14.37440714 13.85862616 13.82517016 14.0312798 14.24886567 14.2787702 14.79388225 15.31125571 15.3405679 15.13531655 14.9225679 14.90989779 14.4297829 13.94864184 14.01594722 14.30321138 14.5951049 14.65967732 15.16303927 15.66709875 15.61862128 15.36727812 15.10499052 15.0862465 14.6697955 14.24905529 14.42357699 14.79555573 15.18017536 15.29757103 15.80996584 16.31992961 16.23147574 15.95965239 15.68195228 15.68967569 15.33694704 15.0035088 15.3041353 15.76916284 16.24721396 16.43308671 16.97919075 17.5260659 17.42214667 17.16464438 16.90175239 17.00675083 16.78110473 16.54272994 16.97866589 17.5869564 18.19639127 18.46583867 19.07611192 19.69134726 19.60801767 19.36210837 19.11507165 19.24745137 19.09356727 18.94322468 19.51099154 20.24524486 20.99747324 21.38802071 22.09808672 22.82403004 22.79681805 22.63111509 22.46329997 22.75432966 22.74317763 22.74563268 23.60298828 24.62641952 25.71023129 26.38465762 27.38959181 28.43075981 28.60111458 28.65090074 28.72001382 29.30550978 29.62868532 29.98541509 31.35683496 32.95554184 34.65477734 35.92877034 37.61016069 39.42537492 40.24658677 41.06533425 42.05543877 43.92596803 45.7379044 47.84406095 51.63268945 56.12031427 61.27269685 66.43153064 73.03880403 81.11909328 89.20805212 99.71241641 114.5974755 138.6497553 179.8314209 266.2614704 457.6832803 622.9213387 801.7050155 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
			String intRate = "0.1541 0.240437 0.286579 0.266965 0.249286 0.242536 0.257476 0.274463 0.286671 0.302785 0.330198 0.368561 0.413835 0.477572 0.545549 0.603775 0.678653 0.755977 0.845735 0.930255 1.022947 1.132342 1.226031 1.337725 1.421578 1.524328 1.611101 1.701945 1.793158 1.893739 1.981142 2.075033 2.160542 2.235037 2.312459 2.366128 2.422133 2.495455 2.556003 2.610648 2.670941 2.733549 2.789501 2.844647 2.894638 2.945437 3.007181 3.065592 3.116391 3.175498 3.226353 3.268878 3.324264 3.367732 3.40025 3.425601 3.458438 3.496039 3.529288 3.55716 3.582818 3.595696 3.615859 3.644204 3.673587 3.701385 3.731989 3.75913 3.790098 3.809081 3.83927 3.865629 3.894568 3.922214 3.952965 3.963498 3.988808 4.018124 4.027179 4.039356 4.053116 4.070002 4.082637 4.090338 4.084805 4.095108 4.102609 4.117176 4.139277 4.156496 4.174226 4.198952 4.217609 4.239521 4.260352 4.274389 4.293444 4.321215 4.34978 4.366314 4.391027 4.402444 4.417346 4.429823 4.441565 4.451327 4.456503 4.464276 4.47449 4.489614 4.499304 4.50768 4.519682 4.530716 4.549262 4.562161 4.576456 4.584549 4.598283 4.61433 4.633223 4.645916 4.660546 4.670505 4.682125 4.685659 4.684013 4.701128 4.713001 4.726238 4.734258 4.747231 4.742282 4.75904 4.77296 4.784668 4.784907 4.798747 4.806773 4.809409 4.807999 4.819097 4.829421 4.838918 4.839314 4.845635 4.846909 4.855524 4.860758 4.86413 4.8676 4.872995 4.872152 4.87677 4.87935 4.879526 4.885741 4.892006 4.888123 4.883643 4.880848 4.894689 4.898091 4.892615 4.88929 4.886023 4.88592 4.883375 4.886963 4.884938 4.887352 4.882902 4.883171 4.877369 4.879913 4.880939 4.886121 4.888932 4.889196 4.901249 4.904449 4.905752 4.913704 4.911504 4.906375 4.911665 4.912401 4.908452 4.897713 4.898496 4.884168 4.875237 4.869408 4.863799 4.874075 4.868367 4.867095 4.872792 4.873638 4.876734 4.873895 4.871532 4.867438 4.874434 4.882051 4.881958 4.88482 4.890045 4.900702 4.913644 4.917039 4.9316 4.93662 4.921361 4.935162 4.939904 4.945359 4.946481 4.946731 4.947812 4.951426 4.952199 4.955771 4.954738 4.958203 4.950125 4.955802 4.964986 4.956616 4.960737 4.966201 4.976188 4.987709 4.992715 4.995261 4.995487 4.999113 5.016857 5.025177 5.035271 5.046762 5.047993 5.046543 5.046186 5.048043 5.044277 5.042867 5.034717 5.027638 5.017683 5.024885 5.015926 5.009268 5.002605 4.982327 4.978362 4.981519 4.981625 4.969276 4.957589 4.955694 4.952236 4.944861 4.941354 4.933261 4.929738 4.932421 4.946521 4.942915 4.940538 4.953249 4.959329 4.959567 4.964187 4.964491 4.965054 4.964668 4.970665 4.988784 4.990673 5.010061 5.023962 5.036636 5.045681 5.058606 5.070796 5.079723 5.080643 5.094493 5.093748 5.108219 5.116293 5.125922 5.136139 5.144617 5.163133 5.176258 5.196383 5.213887 5.236368 5.248635 5.252397 5.271713 5.280052 5.297479 5.303368 5.309464 5.318155 5.330949 5.347307 5.362742 5.372419 5.377205 5.390867 5.401109 5.406177 5.40814 5.424206 5.425489 5.432041 5.433977 5.439831 5.438302 5.449037 5.460009 5.463292 5.466026 5.465256 5.483071 5.480088 5.493475 5.494992 5.503075 5.515515 5.525137 5.531303 5.536322 5.539803 5.534989 5.536864 5.551017 5.557953 5.567627 5.573926 5.577187 5.575965 5.579259 5.589368 5.597477 5.599061 5.613175 5.619317 5.641945 5.65531 5.660106 5.661547 5.663653 5.665462 5.666336 5.667375 5.677234 0.1541 0.243753 0.287331 0.264622 0.250544 0.24368 0.26565 0.272099 0.289083 0.282793 0.309561 0.345801 0.400594 0.460922 0.524133 0.587136 0.651398 0.715186 0.792886 0.882129 0.960928 1.047643 1.139476 1.22399 1.318347 1.41098 1.503627 1.588004 1.678403 1.784546 1.871909 1.946109 2.029009 2.102625 2.176341 2.240431 2.288549 2.347309 2.410439 2.45768 2.493918 2.539809 2.591407 2.640612 2.679867 2.734523 2.793493 2.835679 2.911221 2.958993 3.022893 3.068946 3.122787 3.174528 3.218781 3.261526 3.307793 3.347481 3.389769 3.428291 3.456823 3.479969 3.509582 3.513994 3.533939 3.554909 3.588667 3.624543 3.656184 3.69242 3.727626 3.762314 3.799663 3.836216 3.873853 3.912664 3.948777 3.986967 4.016605 4.025883 4.054768 4.073221 4.087779 4.104743 4.113261 4.116668 4.13564 4.160067 4.171305 4.178692 4.199055 4.229065 4.251791 4.267618 4.277597 4.292351 4.296373 4.324978 4.344858 4.362337 4.377443 4.378651 4.407379 4.420994 4.432728 4.446807 4.454207 4.465142 4.45938 4.450148 4.452931 4.453121 4.464619 4.462022 4.468353 4.469911 4.475871 4.466842 4.46844 4.46647 4.478154 4.479937 4.487486 4.501407 4.5111 4.509368 4.513533 4.518931 4.516363 4.527062 4.530073 4.564195 4.576328 4.580342 4.593655 4.611623 4.619899 4.647005 4.653198 4.657223 4.653759 4.667178 4.672774 4.673498 4.670148 4.668509 4.685177 4.682671 4.692249 4.691817 4.707566 4.707314 4.696589 4.700791 4.706389 4.69899 4.704829 4.714406 4.703057 4.717642 4.725453 4.748085 4.757687 4.763393 4.763321 4.773438 4.773677 4.77639 4.777003 4.773925 4.786438 4.787176 4.78322 4.790965 4.794492 4.800338 4.807305 4.804592 4.809935 4.813975 4.81059 4.815376 4.823335 4.825182 4.838582 4.832934 4.83936 4.841944 4.8531 4.854544 4.86142 4.86352 4.858684 4.855493 4.862028 4.846111 4.848434 4.852448 4.857708 4.856638 4.862537 4.861278 4.878796 4.888959 4.890158 4.894401 4.900334 4.904916 4.906359 4.910932 4.915638 4.912165 4.90524 4.900507 4.900706 4.898817 4.878449 4.876625 4.876747 4.885542 4.889908 4.886808 4.884459 4.884431 4.874839 4.868274 4.865598 4.857587 4.853503 4.85049 4.854852 4.856672 4.876596 4.874134 4.881522 4.889463 4.891958 4.888648 4.895513 4.905635 4.901514 4.900796 4.896982 4.902986 4.904966 4.903302 4.905594 4.887747 4.901641 4.889168 4.89951 4.895283 4.897101 4.901951 4.908118 4.915434 4.92615 4.929303 4.94072 4.952698 4.948281 4.948046 4.94166 4.931209 4.929217 4.941229 4.941792 4.941366 4.936557 4.947864 4.951935 4.944542 4.948687 4.949713 4.95387 4.951571 4.955007 4.962493 4.959445 4.968125 4.967958 4.969217 4.977637 4.972486 4.984478 4.995192 5.006766 5.022906 5.008139 5.021642 5.02554 5.027285 5.030883 5.025632 5.041289 5.065376 5.079109 5.100359 5.140522 5.153928 5.162866 5.18116 5.194556 5.207387 5.219046 5.226441 5.24941 5.268905 5.269557 5.274275 5.282935 5.296361 5.302502 5.314701 5.326084 5.328491 5.32733 5.336678 5.332379 5.330812 5.318102 5.323197 5.324167 5.327452 5.32541 5.347479 5.355659 5.3555 5.360632 5.361345 5.360044 5.359776 5.358818 5.363137 5.377502 5.369374 5.369337 5.377661 5.383324 5.386833 5.390579 5.407866 5.417181 5.412911 5.404356 5.403823 5.395371 5.386008 5.368871 5.378935 5.375738 5.369788 5.372686 5.372942 5.383691 5.369033 5.373013 5.37879 5.391775 5.397184 5.415212";

			KeyVal argOptions = new KeyVal();
			KeyVal argHandle = new KeyVal();
			KeyVal argDeal = new KeyVal();
			KeyVal argUser = new KeyVal();
			KeyVal argCF = new KeyVal();
			KeyVal argLoanscens = new KeyVal();
			KeyVal argPropscens = new KeyVal();
			KeyVal argStats = new KeyVal();
			
			argHandle.add("PERL_OUT_FILENAME","/vn_le/en2_data_d/intex/test_intex/intex_debug/output/wrapperdebug.pl");
			argHandle.add("PERL_EMBED_OUTPUT_AS_COMMENT","1");
			argHandle.add("PERL_SORT_KEYWORDS","1");

			argOptions.add("CDI_PATH", IntexWrapTest.CDI_PATH());
			argOptions.add("CDU_PATH", IntexWrapTest.CDU_PATH());
			argOptions.add("ACCESS_KEYCODE", accessCode);
			argOptions.add("ACCESS_CLIENT", companyName);
			argOptions.add("USE_HIST_ALL", "BASE_ONLY");
			argOptions.add("SETTLE_WITH_CDU_DATE", "CDU_DATE");
			argOptions.add("LOANS_CONTROLS_LIMIT", "0");
/*			argOptions.add("DEAL_INFO_DEALNAME", dealName);
			argOptions.add("DEAL_INFO_WANTED", "OPTREDEEMS|TRBLOCK_ORIGBALS");
			argOptions.add("DEAL_INFO_TRANCHENAME", "M1");
*/			
			argOptions.add("COLLAT_LIST_TOP_LEVEL","0");
			
			argOptions.add("ISR_FILENAME","/vn_le/en2_data_d/intex/test_intex/intex_debug/output/vcmowrap.isr");
			
			argDeal.add("DEAL_NAME", dealName);
/*			argDeal.add("DEAL_MODE", "SEASONED_POOLS");
			argDeal.add("DEAL_MODE", "NEW");
*/			argDeal.add("DEAL_MODE", "SEASONED_CLUSTERS");
			argDeal.add("SETTLE_YYYYMMDD", "20140515");

			argCF.add("PREPAY_UNITS", "SMM");
			argCF.add("PREPAY_RATE", prepayCurve);
			argCF.add("LOSS_UNITS", "MDR");
			argCF.add("LOSS_RATE", lossCurve);
			
/*			argCF.add("PREPAY_UNITS[1]", "SMM");
			argCF.add("PREPAY_RATE[1]", prepayCurve1);
			argCF.add("LOSS_UNITS[1]", "MDR");
			argCF.add("LOSS_RATE[1]", lossCurve1);*/
			argCF.add("PREPAY_UNITS[2]", "SMM");
			argCF.add("PREPAY_RATE[2]", prepayCurve2);
			argCF.add("LOSS_UNITS[2]", "MDR");
			argCF.add("LOSS_RATE[2]", lossCurve2);
			argCF.add("LOSS_SEERITY_METHOD","SEVERITY_STANDARD");
			argCF.add("LOSS_SEVERITY_SOURCE","SEVERITY_RATE");
			argCF.add("LOSS_SEVERITY_UNITS","SEVERITY");
			argCF.add("LOSS_SEVERITY",severityCurve);
			argCF.add("LIBOR_1MO", intRate);
/*			argCF.add("SCENARIO_TYPE", "DEAL");
*/			argCF.add("SCENARIO_TYPE", "GROUP");
			argCF.add("TRANCHE_ROW", "-1");
			argCF.add("DEAL_LEVEL_IS_BASE_CASE", "1");
			
/*			argCF.add("USE_QUERY_SCRIPT", "BOTTOM_ASSETS");
*/
			argCF.add("OPTREDEEM_FORECAST_METHOD", "BY_EXPRESSION");
			argCF.add("OPTREDEEM_CALL_WHEN[CTAS14C1::CLEANUP]", "ASAP");
			argCF.add("USE_DELINQ_HIST", "HIST_DELINQ_ACTUAL");
			argOptions.add("FULL_CASHFLOW_DETAIL", "FULL");
			
			argOptions.add("FILL_MISSING_RATES_FROM_IDX", "1");
			argStats.add("RUN_TYPE", "CASHFLOWS");
			argStats.add("SHOW_CASHFLOWS_MODE", "FORECASTED");
			
			IntexWrap instance = new IntexWrap(argHandle.toString(),argUser.toString(),DataOut);
			System.out.print(DataOut.toString());

			String retString = instance.deal(argOptions.toString(),
					argDeal.toString());
/*			String ret1String = instance.deal_info(argOptions.toString(), null);
*/			String retCollat = instance.collat(argOptions.toString(), argDeal.toString());
			System.out.println(retString);

			String ret2String = instance.cashflow(argOptions.toString(), null,
					argCF.toString(), argLoanscens.toString(), argPropscens.toString());
			
			System.out.println(retString);
/*			System.out
					.println("***********************Deal Info Output Below***************************************");
			System.out.println(ret1String);
*/			
			System.out
			.println("***********************Collat Output Below***************************************");
			System.out.println(retCollat);

			System.out
					.println("***********************Cashflow Output Below***************************************");
			System.out.println(ret2String);

			for (String trancheName : trancheNames) {
				argStats.add("TRANCHE_ROW", trancheName);
				String ret3String = instance.stats(argOptions.toString(), null,
						argCF.toString(), argStats.toString());
				System.out
						.println("***********************" + trancheName + " Stats Output Below***************************************");
				System.out.println(ret3String);
			}

			instance.exit();

/*			File file = new File(
					"/vn_le/en2_data_d/intex/test_intex/intex_debug/output/IntexOutput.txt");
			try (FileOutputStream fop = new FileOutputStream(file)) {

				// if file doesn't exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// get the content in bytes
				byte[] contentInBytes = retCollat.getBytes();

				fop.write(contentInBytes);
				fop.flush();
				fop.close();

				System.out.println("Write file successful.");

			} catch (IOException e) {
				e.printStackTrace();
			}
*/
		} catch (IntexWrapParseException e1) {
			System.out.println("Error!:" + e1.toString());
			System.out.println("\n\nDataOut:\n" + e1.getDataOut());
		} catch (IntexWrapException e1) {
			System.out.println("Error!:" + e1.toString());
		}
	}
}