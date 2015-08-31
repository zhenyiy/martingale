import com.intex.IntexWrap;
import com.intex.IntexWrapException;
import com.intex.IntexWrapParseException;
import com.intex.KeyVal;

public class IntexWrapTest5 {
	static {
		System.setProperty("LD_LIBRARY_PATH", "/vn_le/en2_data_d/intex/test_intex/testIntex2/src");
		System.setProperty("java.library.path", "/vn_le/en2_data_d/intex/test_intex/testIntex2");
		System.loadLibrary("IntexWrapJNI"); // Notice lack of lib
		System.loadLibrary("vcmowrap"); // Notice lack of lib prefix
	}

	
	
	private static String CDI_PATH() {
		if (System.getProperty("file.separator").equals("/"))
			return "/vn_cont/intexprod/data/cdi";
			return "s:\\cmo_cdi";
	}

	private static String CDU_PATH() {
		if (System.getProperty("file.separator").equals("/"))
			return "/vn_cont/intexprod/data/cdu";
		return "s:\\cmo_cdu";
	}
	
	public static void callIntex(String dealName, String dealPath, String trancheName,
			String prepayCurve, String lossCurve, String intexOutputFile, String dealMode, String crtSelectDate) {
		
		try {
			StringBuffer DataOut = new StringBuffer("");
			String accessCode = "tbvskobcg1trnufl1";
			String companyName = "FANNIE MAE - PORTFOLIO INVESTMENTS/CHIEF RISK-FINANCIAL OFFICE";
			String intRate = "0.15050000";

			KeyVal argOptions = new KeyVal();
			KeyVal argHandle = new KeyVal();
			KeyVal argDeal = new KeyVal();
			KeyVal argUser = new KeyVal();
			KeyVal argCF = new KeyVal();
			KeyVal argLoanscens = new KeyVal();
			KeyVal argPropscens = new KeyVal();
			KeyVal argStats = new KeyVal();

			argHandle.add("INSTANCE_HANDLE", "2");
/*			argHandle.add("PERL_OUT_FILENAME","/vn_le/en2_data_d/intex/test_intex/intex_debug/output/wrapperdebug.pl");
			argHandle.add("PERL_EMBED_OUTPUT_AS_COMMENT","1");
			argHandle.add("PERL_SORT_KEYWORDS","1");
*/
			// argOptions for wcmo_deal call
			argOptions.add("ACCESS_CLIENT", companyName);
			argOptions.add("ACCESS_KEYCODE", accessCode);
			argOptions.add("ADDL_MBSPOOL_FILES", "GEO");
			argOptions.add("ADDL_MBSPOOL_INFO_FOR_REMICS", "0");
			argOptions.add("ALLOW_REREMIC_CHILD_CF_ACCESS",
					"REFERRED_CHILD_DEAL_ONLY");
			// argOptions.add("CDI_PATH", IntexWrapper.CDI_PATH());
			argOptions.add("CDI_PATH", CDI_PATH());
			argOptions.add("CDU_LOOKBACK_LIMIT_MODE", "NONE");
			argOptions.add("CDU_PATH", CDU_PATH());
			argOptions.add("COLLAT_LIST_TOP_LEVEL", "1");
			argOptions.add("CUSIP_TABLES",
					"CMO|ISIN|MBS|BBGTK|BBGDEAL|BBGID|BDC");
			argOptions.add("DECIMAL_DIGITS_CF_GAP", "2");
			argOptions.add("DECIMAL_DIGITS_CF_TABLE", "9");
			argOptions.add("DECIMAL_DIGITS_CONVEX", "9");
			argOptions.add("DECIMAL_DIGITS_COUP_FAC", "9");
			argOptions.add("DECIMAL_DIGITS_CP", "9");
			argOptions.add("DECIMAL_DIGITS_DEC_TABLE", "0");
			argOptions.add("DECIMAL_DIGITS_DISCOUNTMARGIN", "9");
			argOptions.add("DECIMAL_DIGITS_DURN", "9");
			argOptions.add("DECIMAL_DIGITS_FACTOR", "9");
			argOptions.add("DECIMAL_DIGITS_PERCENT", "9");
			argOptions.add("DECIMAL_DIGITS_PRICE", "9");
			argOptions.add("DECIMAL_DIGITS_SPREAD", "9");
			argOptions.add("DECIMAL_DIGITS_SYMVAR_TABLE", "9");
			argOptions.add("DECIMAL_DIGITS_TICS", "0");
			argOptions.add("DECIMAL_DIGITS_TRIGGER_VAL", "9");
			argOptions.add("DECIMAL_DIGITS_WAL", "9");
			argOptions.add("DECIMAL_DIGITS_WAVG_INTEGER", "9");
			argOptions.add("DECIMAL_DIGITS_YIELD", "9");
			argOptions.add("DO_EXPLODE_MEGAS", "0");
			argOptions.add("DO_FORMAT_TRIGVALS", "1");
			argOptions.add("EXCLUDE_PREFUND_FROM_TERMS", "1");
			argOptions.add("EXTENSIVE_ERROR_CHECKING", "FATAL");
			argOptions.add("FORMAT_DURATION_AS_INTEGER", "1");
			argOptions.add("GET_ABS_SUMMARY_FROM_LATEST_CDU", "1");
			argOptions.add("GET_CHILD_TRIGGERS", "1");
			argOptions.add("HIDE_MODELING_TRANCHES", "0");
			argOptions.add("HIDE_RESTRICTED_TRANCHES", "1");
			argOptions.add("IGNORE_DESCRIPTIVE_INFO", "NONE");
			argOptions.add("IGNORE_PAIDDOWN_COLLAT", "1");
			argOptions.add("INCLUDE_PNOTES", "1");
			argOptions.add("INCLUDE_UNDEFINED_ASSET_INFOS", "1");
			argOptions.add("LOANS_CONTROLS_LIMIT", "0");
			argOptions.add("MAKE_XRS_TRANCHE", "0");
			argOptions.add("MAX_SCHED_ELEMENTS", "ALL");
			argOptions.add("MAX_THREADS", "2");
			argOptions.add("N_PREDEFINED_VARS", "1");
			argOptions.add("PNOTE_MAIN_AS_COLLAT", "0");
			argOptions.add("PREDEFINED_VAR[1]",
					"#_IGNORE_INFO_ONLY_CDU_AS_LATEST_CDU");
			argOptions.add("PRICE_TICS_DECIMAL", "DECIMAL");
			argOptions.add("REQUIRE_CLEANUP_PRECISION", "0");
			argOptions.add("SHOW_GROUP_NAMES", "1");
			argOptions.add("SHOW_HEDGE_TRANCHES", "HEDGENET");
			argOptions.add("SHOW_INTERNAL_DATA_ITEMS", "1");
			argOptions.add("SHOW_PSEUDO_TRANCHES", "1");
			argOptions.add("SINGLE_TRANCHE_MODE", "1");
			argOptions.add("STRUCTURED_ASSET_DATA_PREFERRED_SOURCE",
					"INTEX_DETERMINED");
			argOptions.add("TAG_TRANCHE_WITH_PROVIDED_IDENTIFIER", "1");
			argOptions.add("TRADING_ACCURACY_NOT_REQUIRED", "1");
			argOptions.add("USE_DUEBILL", "ZERO_DELAY_BONDS");
			argOptions.add("USE_VINDEX0", "0");
			argOptions.add("VALID_DATES_ONLY", "1");
			argOptions.add("YLDCRV_NODES", "COMMON|1YR|3YR|7YR");

			if(dealMode.equals("seasoned")) {
				argDeal.add("DEAL_MODE", "SEASONED_EXPLODE");
				argOptions.add("USE_HIST_ALL", "BASE_ONLY");
			}
			else {
				argDeal.add("DEAL_MODE", "NEW");
			}
			
			argDeal.add("DEAL_NAME", dealName);
			argDeal.add("DO_OPTIMIZE_CLUSTERING", "0");
			argDeal.add("DO_STRAT_COLLAT", "0");
			argDeal.add("FACE_AMOUNT_SCALE_BASIS", "SUGGESTED_BAL");
			argDeal.add("SETTLE_YYYYMMDD", crtSelectDate + "01");

			// argOptions added for wcmo_collat call
			argOptions.add("COLLAPSE_SINGLE_ELEMENT_HISTOGRAM", "1");
			argOptions.add("COLLAT_LIST_EXPLODE", "NO_SUMMARY");
			argOptions.add("EXCLUDE_NONCONTRIBUTING_GROUPS", "1");
			argOptions.add("EXCLUDE_PREFUND_FROM_TERMS", "1");
			argOptions.add("FORMAT_DURATION_AS_INTEGER", "1");
			argOptions
					.add("MODHIST_ITEM_LIST",
							"STATUS(24)|STATUS(COUNT,24)|DETAIL(24)|STATUS(60)|STATUS(COUNT,60)|DETAIL(60)");
			argOptions
					.add("PAYSTATUS_ITEM_LIST",
							"HIST(DELINQ,24)|WORST(24)|CURRENT(STATUS_60,24)|HIST(DELINQ_WITH_MOD,24)|WORST_SINCE_MOD(24)|HIST(DELINQ,60)|WORST(60)|CURRENT(STATUS_60,60)|HIST(DELINQ_WITH_MOD,60)|WORST_SINCE_MOD(60)|PREVBAL()|MOS_TO_LIQ()");
			argOptions.add("REMAP_COLLAT_ONLY", "1");
			argOptions.add("SHOW_COLLAT_FOR_STRATS_DATA", "1");
			argOptions.add("SHOW_FMT_DATA_ITEMS", "1");
			argOptions.add("SHOW_REINVEST_COLLAT", "COLLAT_LEVEL");

			// argOptions added for wcmo_uncollat call
			argOptions.add("SHOW_NUMBERS_NO_COMMAS", "ALWAYS");
			argOptions.add("UCOLLAT_SUBSET_ACTION", "DELETE");

			// argOptions added for wcmo_cashflow call
			argOptions
					.add("DEFAULT_LOSS_AT_BALLOON", "ALLOW_LOSS_NEAR_BALLOON");
			argOptions.add("DEFAULT_LOSS_AT_MATURITY", "0_AT_LAG");
			argOptions.add("FULL_CASHFLOW_DETAIL", "FULL");
			argOptions.add("INCLUDE_ASSET_REINV_IN_CF_PRINCIPAL", "0");
			argOptions.add("MOS_BETWEEN_CALLPRO_ROWS", "1");
			argOptions.add("MOS_BETWEEN_CASHFLOW_ROWS", "1");
			argOptions.add("MOS_BETWEEN_DECTABLE_ROWS", "1");
			argOptions.add("OMIT_PERIOD_ZERO_ROW", "0");
			argOptions.add("SHOW_ACCRUED_PRINC_AS_POSITIVE", "1");
			argOptions.add("SHOW_CASHFLOWS_MODE", "ENTITLED");
			argOptions.add("SHOW_CF_TOTALS_TOP", "0");
			argOptions.add("SHOW_NUMBERS_NO_COMMAS", "ALWAYS");
			argOptions.add("SINGLE_TRANCHE_MODE", "1");
			argOptions.add("STRUCTURED_ASSET_DATA_PREFERRED_SOURCE",
					"INTEX_DETERMINED");
			argOptions.add("TREAT_SEVERITY_AS_RECOVERY", "0");

			argCF.add("BUSINESSDAY_METHOD", "DEFAULT");
			argCF.add("DEAL_LEVEL_IS_BASE_CASE", "1");
			argCF.add("DERIVE_SPOT_RATES_FROM_YIELD_CURVE", "1");
			argCF.add("FULL_CASHFLOW_DETAIL", "FULL");
			argCF.add("INDEX_OFFSET_ELEMENTS", "0");
			argCF.add("INDEX_PROXY_APPLY", "ALWAYS");
			argCF.add("LIBOR_1MO", intRate);
			argCF.add("LIBOR_1MO_UNITS", "PERCENT");
			argCF.add("LIBOR_1MO_USERCURVE_TYPE", "NONE");
			argCF.add("LOSS_ALLOW_EXCESS_SEVERITY", "0");
			argCF.add("LOSS_RATE", lossCurve);
			argCF.add("LOSS_SEVERITY", "0");
			argCF.add("LOSS_SEVERITY_IS_GROSS", "0");
			argCF.add("LOSS_UNITS", "MDR");
			argCF.add("LOSS_USERCURVE_TYPE", "NONE");
			argCF.add("N_SCENARIOS", "100");
			argCF.add("OMIT_PERIOD_ZERO_ROW", "0");
			argCF.add("PREFUND_DEFAULT", "LOCKOUT");
			argCF.add("PREFUND_PREPAY", "LOCKOUT");
			argCF.add("PREPAY_RATE", prepayCurve);
			argCF.add("PREPAY_UNITS", "SMM");
			argCF.add("PREPAY_USERCURVE_TYPE", "NONE");
			argCF.add("RECOVER_LAG", "0");
			argCF.add("RECOVER_LAG_USERCURVE_TYPE", "NONE");
			argCF.add("RESOLVE_CONFLICTS", "BY_ANY");
			argCF.add("RETAIN_SCENARIOS", "1");
			argCF.add("RUN_SCENARIO", "1");
			argCF.add("SCENARIO#", "0");
			argCF.add("SCENARIO_TYPE", "LOAN");
			argCF.add("SEGREGATE_QUERY_FORECASTS", "1");
			argCF.add("SERV_ADV", "ADVANCES_ALL_BUT_NEWLY_LIQDTD");
			argCF.add("SERVICER_ADVANCE_DETERMINE_BY_MODEL", "1");
			argCF.add("SEVERITY_USERCURVE_TYPE", "NONE");
			argCF.add("SINGLE_TRANCHE_MODE", "1");
			argCF.add("STORE_CHILD_TRIGSERIES", "1");
			argCF.add("SUPPORT_PCT_FORCE_GROUP_DIRECTED", "0");
			argCF.add("SUPPORT_PCT_IGNORE_INSURANCE", "0");
			argCF.add("USE_QUERY_SCRIPT", "BOTTOM_ASSETS");
			argCF.add("YIELD_CURVE_DAYCOUNT_METHOD_NORMALIZED", "30360");
			argCF.add("YIELD_CURVE_MATURITIES",
					"1MO|3MO|6MO|1YR|2YR|3YR|5YR|7YR|10YR|30YR|");
			argCF.add("YIELD_CURVE_N_NODES", "10");
			argCF.add("YIELD_CURVE_SPREAD_OFF", "WAL_INTERPOLATED");

			// argOptions added for wcmo_ucollat_subset_catalog call
			argCF.add("UCOLLAT_SUBSET_ACTION", "NAMELIST");
			argCF.add("UCOLLAT_SUBSET_DEALNAME", dealName);

			argStats.add("DAYCOUNT_METHOD", "DEFAULT");
			argStats.add("FACE_AMOUNT", "FULL FACE");
			argStats.add("FACE_AMOUNT_SCALE_BASIS", "SUGGESTED_BAL");
			argStats.add("IGNORE_CF_AFTER_BOND_PAYDOWN", "0");
			argStats.add("REPORT_COLLAT_LOSS_LIQ_MODE", "AMOUNT");
			argStats.add("RUN_TYPE", "CASHFLOWS");
			argStats.add("SCENARIO#", "0");
			argStats.add("TRANCHE_ROW", trancheName);

			IntexWrap instance = new IntexWrap(argHandle.toString(),
					argUser.toString(), DataOut);
			System.out.println("IntexWrap instance created.");

			String retDealString = instance.deal(argOptions.toString(),
					argDeal.toString());
			System.out.println("IntexWrap deal command done.");

			String retCollatString = instance.collat(argOptions.toString(),
					argDeal.toString());
			System.out.println("IntexWrap collat command done.");

			String retCollatSubsetString = instance.ucollat_subset_catalog(
					argOptions.toString(), "");
			System.out.println("IntexWrap uncollat command done.");

			String retCFString = instance.cashflow(argOptions.toString(), null,
					argCF.toString(), argLoanscens.toString(),
					argPropscens.toString());
			System.out.println("IntexWrap cashflow command done.");

			String retStatsString = instance.stats(argOptions.toString(), null,
					argCF.toString(), argStats.toString());
			System.out.println("IntexWrap stats command done.");

			
			System.out.println("DUBUG - DEAL OUTPUT: " + retDealString);
			System.out.println(" ******** ******************************************");
			System.out.println(retStatsString);

			instance.exit();

		} catch (IntexWrapParseException e1) {
			e1.printStackTrace();

		} catch (IntexWrapException e1) {
			e1.printStackTrace();

		}
	}

	public static void main(String args[]) {

		try {
			String dealName = "ctas15c1";
			String[] trancheNames = {"'1M1'","'1M1H'","'1M2H'","'1M2'","'1AH'","'1BH'","'Class-SUBORD1'","'COLLAT_1'", "COLLAT" };
			String lossCurve = "0.000846 0.001083 0.001385 0.001633 0.001922 0.002259 0.002716 0.003267 0.003932 0.00475 0.005714 0.006751 0.00769 0.00916 0.010792 0.012867 0.015242 0.017762 0.020988 0.024724 0.028974 0.03376 0.03916 0.045132 0.049551 0.053051 0.055966 0.058886 0.061891 0.064445 0.067417 0.070461 0.073432 0.07649 0.078856 0.07987 0.079353 0.078865 0.076874 0.076398 0.075911 0.074837 0.074199 0.073578 0.07187 0.070001 0.067785 0.065937 0.062133 0.0589 0.056587 0.055233 0.053737 0.054749 0.056364 0.058092 0.060161 0.061007 0.061652 0.061985 0.059877 0.057499 0.054312 0.051451 0.048029 0.044348 0.040404 0.036674 0.033487 0.03138 0.029322 0.026179 0.025908 0.025495 0.024759 0.024039 0.023578 0.02323 0.022966 0.022905 0.022846 0.022645 0.022587 0.022469 0.022257 0.022018 0.021818 0.02168 0.021733 0.021644 0.021507 0.021425 0.02112 0.020639 0.02025 0.019915 0.019712 0.019491 0.019299 0.019254 0.019223 0.019209 0.019114 0.019069 0.018994 0.018711 0.018442 0.01818 0.018006 0.017826 0.017673 0.017623 0.017603 0.017579 0.017503 0.01746 0.017378 0.017126 0.01687 0.016622 0.016463 0.016298 0.016138 0.016095 0.016058 0.016014 0.015936 0.015869 0.015782 0.01554 0.015286 0.015056 0.014877 0.014686 0.01451 0.014425 0.014341 0.014267 0.014168 0.014076 0.013966 0.013709 0.013439 0.013196 0.012999 0.012791 0.012601 0.012497 0.012385 0.012287 0.012154 0.012036 0.011914 0.011664 0.011414 0.011188 0.010999 0.010804 0.01064 0.01053 0.010421 0.010334 0.010208 0.010106 0.009989 0.009767 0.009554 0.00935 0.009182 0.009011 0.008863 0.008757 0.008667 0.008583 0.008469 0.008384 0.008277 0.008092 0.007913 0.007739 0.0076 0.007458 0.007328 0.007237 0.007158 0.007075 0.006978 0.006898 0.006801 0.006652 0.006503 0.006363 0.006248 0.006132 0.006024 0.005951 0.00588 0.005807 0.005731 0.005661 0.005583 0.005467 0.005346 0.005238 0.005144 0.005042 0.004952 0.004889 0.004824 0.004765 0.004699 0.00464 0.004579 0.004483 0.004384 0.004298 0.004218 0.004134 0.004064 0.004008 0.00395 0.003902 0.003842 0.003793 0.00374 0.00366 0.003583 0.003512 0.003447 0.003379 0.003323 0.003274 0.003228 0.003189 0.00314 0.003102 0.003059 0.002996 0.002937 0.00288 0.002828 0.002774 0.002728 0.002686 0.002649 0.002615 0.002573 0.002542 0.002503 0.002453 0.002404 0.002357 0.002314 0.002269 0.002229 0.002194 0.002162 0.00213 0.002097 0.002069 0.002035 0.001997 0.001957 0.00192 0.001884 0.001847 0.001814 0.001786 0.001757 0.00173 0.001703 0.001678 0.001651 0.00162 0.001587 0.001558 0.001528 0.001497 0.001469 0.001445 0.001419 0.001397 0.001373 0.001351 0.001329 0.001302 0.001274 0.001251 0.001225 0.001198 0.001175 0.001153 0.00113 0.001111 0.001089 0.00107 0.001049 0.001026 0.001004 0.000983 0.00096 0.000937 0.000916 0.000895 0.000874 0.000855 0.000834 0.000817 0.000797 0.000776 0.000755 0.000736 0.000714 0.000692 0.000671 0.000649 0.000628 0.000606 0.000584 0.000564 0.00054 0.000518 0.000494 0.00047 0.000443 0.000416 0.000387 0.000358 0.000327 0.000294 0.000259 0.000223 0.000182 0.000137 0.00009 0.000044 0.000017 0.000003 0 0 0 0 0 0 0 0 0 0 0";
			String prepayCurve = "0 0.391808 0.423273 0.478864 0.522118 0.550479 0.528667 0.477675 0.494697 0.421248 0.453053 0.351284 0.417303 0.529576 0.527234 0.554081 0.64427 0.632178 0.598305 0.530991 0.508865 0.454247 0.457602 0.345302 0.437495 0.563791 0.516513 0.574594 0.607476 0.538356 0.589207 0.475326 0.4533 0.444647 0.414472 0.35746 0.421973 0.553559 0.498927 0.612102 0.642954 0.584721 0.639148 0.496915 0.513336 0.476823 0.427321 0.370981 0.420315 0.531108 0.510332 0.598761 0.603104 0.59466 0.609236 0.453353 0.495021 0.43259 0.382261 0.325917 0.368005 0.44786 0.473001 0.543179 0.529285 0.568604 0.550659 0.446101 0.475191 0.407359 0.398741 0.317324 0.363316 0.500885 0.514743 0.554542 0.654912 0.656 0.639571 0.580835 0.58509 0.54888 0.568863 0.432137 0.520534 0.674175 0.641745 0.667404 0.760571 0.721486 0.743709 0.628259 0.584373 0.562691 0.534026 0.400224 0.488375 0.656084 0.611705 0.708423 0.776417 0.701729 0.781442 0.622475 0.573195 0.548485 0.497822 0.398682 0.489311 0.663803 0.599872 0.753845 0.795289 0.721281 0.797135 0.616883 0.625036 0.564838 0.489473 0.415511 0.493432 0.607678 0.643086 0.744009 0.726971 0.782875 0.76942 0.623348 0.650704 0.545679 0.528819 0.424636 0.497917 0.624152 0.663069 0.737382 0.785467 0.802358 0.751173 0.651212 0.640362 0.511615 0.531942 0.391202 0.486978 0.64783 0.660435 0.704183 0.822025 0.802891 0.755079 0.65745 0.630198 0.554726 0.554451 0.38768 0.499369 0.687347 0.667506 0.714892 0.833737 0.778142 0.789726 0.650489 0.59997 0.574984 0.542412 0.380909 0.502327 0.683322 0.612476 0.782642 0.833186 0.748791 0.828007 0.628447 0.635452 0.583355 0.517661 0.436436 0.521034 0.691419 0.67826 0.820176 0.834633 0.816913 0.855832 0.617347 0.669737 0.586701 0.522006 0.436028 0.515232 0.65326 0.696555 0.81434 0.803295 0.868308 0.847409 0.675721 0.705454 0.589747 0.56711 0.445841 0.524917 0.664658 0.704624 0.784486 0.846131 0.871372 0.817405 0.712817 0.713001 0.579181 0.609342 0.44885 0.547119 0.777099 0.755192 0.804298 0.92952 0.864363 0.883608 0.729003 0.66675 0.63337 0.5997 0.421022 0.547099 0.762067 0.710772 0.84163 0.9441 0.848572 0.942928 0.748409 0.689874 0.654858 0.591796 0.451849 0.559268 0.774987 0.69353 0.8836 0.93867 0.838731 0.927973 0.69689 0.698832 0.632556 0.548746 0.449411 0.545322 0.734797 0.715509 0.878517 0.899566 0.879892 0.932525 0.668769 0.733982 0.640416 0.559754 0.458776 0.568618 0.729912 0.777281 0.870398 0.934221 0.953835 0.886638 0.757353 0.755006 0.601333 0.626447 0.444381 0.570463 0.776928 0.792664 0.853711 1.00659 0.984176 0.920001 0.785637 0.750937 0.652606 0.648182 0.436724 0.590096 0.843179 0.826618 0.891983 1.050675 0.983817 1.004748 0.819311 0.750672 0.713246 0.676347 0.456651 0.617637 0.885293 0.830506 0.987444 1.114779 0.998769 1.116345 0.875902 0.808131 0.771399 0.702213 0.522347 0.687182 0.930463 0.913091 1.135813 1.176906 1.159888 1.238775 0.88769 0.98062 0.858341 0.750146 0.607756 0.756689 1.002925 1.082733 1.290903 1.284798 1.39507 1.378744 1.088306 1.155795 0.973934 0.941489 0.733214 0.923406 1.223403 1.3108 1.479462 1.589847 1.620393 1.504888 1.275782 1.268365 1.000234 1.040717 0.725253 0.943405";

			for (String trancheName : trancheNames) {
				System.out.println("Process tranches:" + trancheName);
				IntexWrapTest5.callIntex(dealName, "", trancheName, prepayCurve, lossCurve, "", "seasoned", "201502");
			}

			
		}  catch (Exception e1) {
			System.out.println("Error!:" + e1.toString());
		}
	}
}