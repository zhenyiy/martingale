import com.intex.IntexWrap;
import com.intex.IntexWrapException;
import com.intex.IntexWrapParseException;
import com.intex.KeyVal;

public class IntexWrapTest3 {
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

	public static void main(String args[]) {

		try {
			StringBuffer DataOut = new StringBuffer("");
			String accessCode = "bje388t5op3rci69p";
			String companyName = "FANNIE MAE - PORTFOLIO INVESTMENTS/CHIEF RISK-FINANCIAL OFFICE";
			String dealName = "ctas14c2";
			
			
			KeyVal argOptions = new KeyVal();
			KeyVal argHandle = new KeyVal();
			KeyVal argDeal = new KeyVal();
			KeyVal argUser = new KeyVal();
/*			KeyVal argCF = new KeyVal();
			KeyVal argLoanscens = new KeyVal();
			KeyVal argPropscens = new KeyVal();
			KeyVal argStats = new KeyVal();
*/			
			argHandle.add("PERL_OUT_FILENAME","/vn_le/en2_data_d/intex/test_intex/intex_debug/output/wrapperdebug.pl");
			argHandle.add("PERL_EMBED_OUTPUT_AS_COMMENT","1");
			argHandle.add("PERL_SORT_KEYWORDS","1");
			argHandle.add("INSTANCE_HANDLE","2");
			
			//argOptions for wcmo_deal call
			argOptions.add("ACCESS_CLIENT", companyName);
			argOptions.add("ACCESS_KEYCODE", accessCode);
			argOptions.add("ADDL_MBSPOOL_FILES","GEO");
			argOptions.add("ADDL_MBSPOOL_INFO_FOR_REMICS","0");
			argOptions.add("ALLOW_REREMIC_CHILD_CF_ACCESS","REFERRED_CHILD_DEAL_ONLY");
			argOptions.add("CDI_PATH", IntexWrapTest3.CDI_PATH());
			argOptions.add("CDU_LOOKBACK_LIMIT_MODE","NONE");
			argOptions.add("CDU_PATH", IntexWrapTest3.CDU_PATH());
			argOptions.add("COLLAT_LIST_TOP_LEVEL","1");
			argOptions.add("CUSIP_TABLES","CMO|ISIN|MBS|BBGTK|BBGDEAL|BBGID|BDC");
			argOptions.add("DECIMAL_DIGITS_CF_GAP","2");
			argOptions.add("DECIMAL_DIGITS_CF_TABLE","9");
			argOptions.add("DECIMAL_DIGITS_CONVEX","9");
			argOptions.add("DECIMAL_DIGITS_COUP_FAC","9");
			argOptions.add("DECIMAL_DIGITS_CP","9");
			argOptions.add("DECIMAL_DIGITS_DEC_TABLE","0");
			argOptions.add("DECIMAL_DIGITS_DISCOUNTMARGIN","9");
			argOptions.add("DECIMAL_DIGITS_DURN","9");
			argOptions.add("DECIMAL_DIGITS_FACTOR","9");
			argOptions.add("DECIMAL_DIGITS_PERCENT","9");
			argOptions.add("DECIMAL_DIGITS_PRICE","9");
			argOptions.add("DECIMAL_DIGITS_SPREAD","9");
			argOptions.add("DECIMAL_DIGITS_SYMVAR_TABLE","9");
			argOptions.add("DECIMAL_DIGITS_TICS","0");
			argOptions.add("DECIMAL_DIGITS_TRIGGER_VAL","9");
			argOptions.add("DECIMAL_DIGITS_WAL","9");
			argOptions.add("DECIMAL_DIGITS_WAVG_INTEGER","9");
			argOptions.add("DECIMAL_DIGITS_YIELD","9");
			argOptions.add("DO_EXPLODE_MEGAS","0");
			argOptions.add("DO_FORMAT_TRIGVALS","1");
			argOptions.add("EXCLUDE_PREFUND_FROM_TERMS","1");
			argOptions.add("EXTENSIVE_ERROR_CHECKING","FATAL");
			argOptions.add("FORMAT_DURATION_AS_INTEGER","1");
			argOptions.add("GET_ABS_SUMMARY_FROM_LATEST_CDU","1");
			argOptions.add("GET_CHILD_TRIGGERS","1");
			argOptions.add("HIDE_MODELING_TRANCHES","0");
			argOptions.add("HIDE_RESTRICTED_TRANCHES","1");
			argOptions.add("IGNORE_DESCRIPTIVE_INFO","NONE");
			argOptions.add("IGNORE_PAIDDOWN_COLLAT","1");
			argOptions.add("INCLUDE_PNOTES","1");
			argOptions.add("INCLUDE_UNDEFINED_ASSET_INFOS","1");
			argOptions.add("LOANS_CONTROLS_LIMIT", "0");
			argOptions.add("ISR_FILENAME","/vn_le/en2_data_d/intex/test_intex/intex_debug/output/vcmowrap.isr");
			argOptions.add("MAKE_XRS_TRANCHE","0");
			argOptions.add("MAX_SCHED_ELEMENTS","ALL");
			argOptions.add("MAX_THREADS","2");
			argOptions.add("N_PREDEFINED_VARS","1");
			argOptions.add("PNOTE_MAIN_AS_COLLAT","0");
			argOptions.add("PREDEFINED_VAR[1]","#_IGNORE_INFO_ONLY_CDU_AS_LATEST_CDU");
			argOptions.add("PRICE_TICS_DECIMAL","DECIMAL");
			argOptions.add("REQUIRE_CLEANUP_PRECISION","0");
			argOptions.add("SHOW_GROUP_NAMES","1");
			argOptions.add("SHOW_HEDGE_TRANCHES","HEDGENET");
			argOptions.add("SHOW_INTERNAL_DATA_ITEMS","1");
			argOptions.add("SHOW_PSEUDO_TRANCHES","1");
			argOptions.add("SINGLE_TRANCHE_MODE","1");
			argOptions.add("STRUCTURED_ASSET_DATA_PREFERRED_SOURCE","INTEX_DETERMINED");
			argOptions.add("TAG_TRANCHE_WITH_PROVIDED_IDENTIFIER","1");
			argOptions.add("TRADING_ACCURACY_NOT_REQUIRED","1");
			argOptions.add("USE_DUEBILL","ZERO_DELAY_BONDS");
			argOptions.add("USE_HIST_ALL", "BASE_ONLY");
			argOptions.add("USE_VINDEX0", "0");
			argOptions.add("VALID_DATES_ONLY","1");
			argOptions.add("YLDCRV_NODES","COMMON|1YR|3YR|7YR");
			argOptions.add("SETTLE_WITH_CDU_DATE", "CDU_DATE");
			
			argDeal.add("DEAL_MODE", "SEASONED_EXPLODE");
//			argDeal.add("DEAL_MODE", "NEW");
			argDeal.add("DEAL_NAME", dealName);
			argDeal.add("DO_OPTIMIZE_CLUSTERING", "0");
			argDeal.add("DO_STRAT_COLLAT", "0");
			argDeal.add("FACE_AMOUNT_SCALE_BASIS", "SUGGESTED_BAL");
			argDeal.add("SETTLE_YYYYMMDD", "20140831");
			
			//argOptions added for wcmo_deal_info call
			argOptions.add("DEAL_INFO_DEALNAME", dealName);
			argOptions.add("DEAL_INFO_GROUP", "1");
			argOptions.add("DEAL_INFO_WANTED", "TRANCHE_NAMES|DEAL_ISSUE_DATE|GROUPS|GRP_CURBAL");
//			argOptions.add("DEAL_INFO_WANTED","GRP_CURBAL");
			
/*			//argOptions added for wcmo_collat call
			argOptions.add("COLLAPSE_SINGLE_ELEMENT_HISTOGRAM","1");
			argOptions.add("COLLAT_LIST_EXPLODE","NO_SUMMARY");
			argOptions.add("EXCLUDE_NONCONTRIBUTING_GROUPS","1");
			argOptions.add("EXCLUDE_PREFUND_FROM_TERMS","1");
			argOptions.add("FORMAT_DURATION_AS_INTEGER","1");
			argOptions.add("MODHIST_ITEM_LIST","STATUS(24)|STATUS(COUNT,24)|DETAIL(24)|STATUS(60)|STATUS(COUNT,60)|DETAIL(60)");
			argOptions.add("PAYSTATUS_ITEM_LIST","HIST(DELINQ,24)|WORST(24)|CURRENT(STATUS_60,24)|HIST(DELINQ_WITH_MOD,24)|WORST_SINCE_MOD(24)|HIST(DELINQ,60)|WORST(60)|CURRENT(STATUS_60,60)|HIST(DELINQ_WITH_MOD,60)|WORST_SINCE_MOD(60)|PREVBAL()|MOS_TO_LIQ()");
			argOptions.add("REMAP_COLLAT_ONLY","1");
			argOptions.add("SHOW_COLLAT_FOR_STRATS_DATA","1");
			argOptions.add("SHOW_FMT_DATA_ITEMS","1");
			argOptions.add("SHOW_REINVEST_COLLAT","COLLAT_LEVEL");
			
			//argOptions added for wcmo_uncollat call
			argOptions.add("SHOW_NUMBERS_NO_COMMAS","ALWAYS");
			argOptions.add("UCOLLAT_SUBSET_ACTION","DELETE");

			//argOptions added for wcmo_cashflow call
			argOptions.add("DEFAULT_LOSS_AT_BALLOON","ALLOW_LOSS_NEAR_BALLOON");
			argOptions.add("DEFAULT_LOSS_AT_MATURITY","0_AT_LAG");
			argOptions.add("FULL_CASHFLOW_DETAIL","FULL");
			argOptions.add("INCLUDE_ASSET_REINV_IN_CF_PRINCIPAL","0");
			argOptions.add("MOS_BETWEEN_CALLPRO_ROWS","1");
			argOptions.add("MOS_BETWEEN_CASHFLOW_ROWS","1");
			argOptions.add("MOS_BETWEEN_DECTABLE_ROWS","1");
			argOptions.add("OMIT_PERIOD_ZERO_ROW","0");
			argOptions.add("SHOW_ACCRUED_PRINC_AS_POSITIVE","1");
			argOptions.add("SHOW_CASHFLOWS_MODE","ENTITLED");
			argOptions.add("SHOW_CF_TOTALS_TOP","0");
			argOptions.add("SHOW_NUMBERS_NO_COMMAS","ALWAYS");
			argOptions.add("SINGLE_TRANCHE_MODE","1");
			argOptions.add("STRUCTURED_ASSET_DATA_PREFERRED_SOURCE","INTEX_DETERMINED");
			argOptions.add("TREAT_SEVERITY_AS_RECOVERY","0");
			
			argCF.add("BUSINESSDAY_METHOD","DEFAULT");
			argCF.add("DEAL_LEVEL_IS_BASE_CASE","1");
			argCF.add("DERIVE_SPOT_RATES_FROM_YIELD_CURVE","1");
			argCF.add("FULL_CASHFLOW_DETAIL","FULL");
			argCF.add("INDEX_OFFSET_ELEMENTS","0");
			argCF.add("INDEX_PROXY_APPLY","ALWAYS");
			argCF.add("LIBOR_1MO", intRate);
			argCF.add("LIBOR_1MO_UNITS","PERCENT");
			argCF.add("LIBOR_1MO_USERCURVE_TYPE","NONE");
			argCF.add("LOSS_ALLOW_EXCESS_SEVERITY","0");
			argCF.add("LOSS_RATE",lossCurve);
			argCF.add("LOSS_SEVERITY","0");
			argCF.add("LOSS_SEVERITY_IS_GROSS","0");
			argCF.add("LOSS_UNITS","MDR");
			argCF.add("LOSS_USERCURVE_TYPE","NONE");
			argCF.add("N_SCENARIOS","100");
			argCF.add("OMIT_PERIOD_ZERO_ROW","0");
			argCF.add("PREFUND_DEFAULT","LOCKOUT");
			argCF.add("PREFUND_PREPAY","LOCKOUT");
			argCF.add("PREPAY_RATE", prepayCurve);
			argCF.add("PREPAY_UNITS","SMM");
			argCF.add("PREPAY_USERCURVE_TYPE","NONE");
			argCF.add("RECOVER_LAG","0");
			argCF.add("RECOVER_LAG_USERCURVE_TYPE","NONE");
			argCF.add("RESOLVE_CONFLICTS","BY_ANY");
			argCF.add("RETAIN_SCENARIOS","1");
			argCF.add("RUN_SCENARIO","1");
			argCF.add("SCENARIO#","0");
			argCF.add("SCENARIO_TYPE","LOAN");
			argCF.add("SEGREGATE_QUERY_FORECASTS","1");
			argCF.add("SERV_ADV","ADVANCES_ALL_BUT_NEWLY_LIQDTD");
			argCF.add("SERVICER_ADVANCE_DETERMINE_BY_MODEL","1");
			argCF.add("SEVERITY_USERCURVE_TYPE","NONE");
			argCF.add("SINGLE_TRANCHE_MODE","1");
			argCF.add("STORE_CHILD_TRIGSERIES","1");
			argCF.add("SUPPORT_PCT_FORCE_GROUP_DIRECTED","0");
			argCF.add("SUPPORT_PCT_IGNORE_INSURANCE","0");
			argCF.add("USE_QUERY_SCRIPT","BOTTOM_ASSETS");
			argCF.add("YIELD_CURVE_DAYCOUNT_METHOD_NORMALIZED","30360");
			argCF.add("YIELD_CURVE_MATURITIES","1MO|3MO|6MO|1YR|2YR|3YR|5YR|7YR|10YR|30YR|");
			argCF.add("YIELD_CURVE_N_NODES","10");
			argCF.add("YIELD_CURVE_SPREAD_OFF","WAL_INTERPOLATED");
			
			//argOptions added for wcmo_ucollat_subset_catalog call
			argCF.add("UCOLLAT_SUBSET_ACTION","NAMELIST");
			argCF.add("UCOLLAT_SUBSET_DEALNAME",dealName);
			
			argStats.add("DAYCOUNT_METHOD","DEFAULT");
			argStats.add("FACE_AMOUNT","FULL FACE");
			argStats.add("FACE_AMOUNT_SCALE_BASIS","SUGGESTED_BAL");
			argStats.add("IGNORE_CF_AFTER_BOND_PAYDOWN","0");
			argStats.add("REPORT_COLLAT_LOSS_LIQ_MODE","AMOUNT");
			argStats.add("RUN_TYPE","CASHFLOWS");
			argStats.add("SCENARIO#","0");
			argStats.add("TRANCHE_ROW","-1");
*/			
			IntexWrap instance = new IntexWrap(argHandle.toString(),argUser.toString(),DataOut);
//			System.out.print(DataOut.toString());

			String retDealString = instance.deal(argOptions.toString(),
					argDeal.toString());
			
			String retDealInfoString = instance.deal_info(argOptions.toString(), null);
			
/*			String retCollatString = instance.collat(argOptions.toString(), argDeal.toString());
			
			String retCollatSubsetString = instance.ucollat_subset_catalog(	argOptions.toString(),"" );

			String retCFString = instance.cashflow(argOptions.toString(), null,
					argCF.toString(), argLoanscens.toString(), argPropscens.toString());
			System.out
			.println("***********************Deal Output Below***************************************");
			System.out.println(retDealString);
*/			
			
			String[] lines = retDealInfoString.split(System.getProperty("line.separator"));
			for(String line : lines){
				System.out.println(line);
			}
			
/*			System.out
			.println("***********************Deal Info Below***************************************");
			System.out.println(retDealInfoString);*/
			
/*			System.out
			.println("***********************Collat Output Below***************************************");
			System.out.println(retCollatString);
			
			System.out
			.println("***********************Ucollat Subset Catalog Output Below***************************************");
			System.out.println(retCollatSubsetString);

			System.out
					.println("***********************Cashflow Output Below***************************************");
			System.out.println(retCFString);

			for (String trancheName : trancheNames) {
				argStats.add("TRANCHE_ROW", trancheName);
				String ret3String = instance.stats(argOptions.toString(), null,
						argCF.toString(), argStats.toString());
				System.out
						.println("***********************" + trancheName + " Stats Output Below***************************************");
				System.out.println(ret3String);
			}
*/
			instance.exit();
		} catch (IntexWrapParseException e1) {
			System.out.println("Error!:" + e1.toString());
			System.out.println("\n\nDataOut:\n" + e1.getDataOut());
		} catch (IntexWrapException e1) {
			System.out.println("Error!:" + e1.toString());
		}
	}
}