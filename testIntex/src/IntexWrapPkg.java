import com.intex.IntexWrap;
import com.intex.IntexWrapException;
import com.intex.IntexWrapParseException;
import com.intex.KeyVal;

public class IntexWrapPkg {
	static {
		System.loadLibrary("IntexWrapJNI"); // Notice lack of lib
		System.loadLibrary("vcmowrap"); // Notice lack of lib prefix
	}

	private static String CDI_PATH() {
		if (System.getProperty("file.separator").equals("/"))
			return "/vn_le/en2_data_d/intex/cdi";
		return "s:\\cmo_cdi";
	}

	private static String CDU_PATH() {
		if (System.getProperty("file.separator").equals("/"))
			return "/vn_le/en2_data_d/intex/cdu";
		return "s:\\cmo_cdu";
	}


	public static void CallIntex(String dealName, String trancheName,
			String prepayCurve, String lossCurve) {
		try {
			StringBuffer DataOut = new StringBuffer("");
			String accessCode = "tbvskobcg1trnufl1";
			String companyName = "FANNIE MAE - PORTFOLIO INVESTMENTS/CHIEF RISK-FINANCIAL OFFICE";
			String intRate = "0.1541 0.240437 0.286579 0.266965 0.249286 0.242536 0.257476 0.274463 0.286671 0.302785 0.330198 0.368561 0.413835 0.477572 0.545549 0.603775 0.678653 0.755977 0.845735 0.930255 1.022947 1.132342 1.226031 1.337725 1.421578 1.524328 1.611101 1.701945 1.793158 1.893739 1.981142 2.075033 2.160542 2.235037 2.312459 2.366128 2.422133 2.495455 2.556003 2.610648 2.670941 2.733549 2.789501 2.844647 2.894638 2.945437 3.007181 3.065592 3.116391 3.175498 3.226353 3.268878 3.324264 3.367732 3.40025 3.425601 3.458438 3.496039 3.529288 3.55716 3.582818 3.595696 3.615859 3.644204 3.673587 3.701385 3.731989 3.75913 3.790098 3.809081 3.83927 3.865629 3.894568 3.922214 3.952965 3.963498 3.988808 4.018124 4.027179 4.039356 4.053116 4.070002 4.082637 4.090338 4.084805 4.095108 4.102609 4.117176 4.139277 4.156496 4.174226 4.198952 4.217609 4.239521 4.260352 4.274389 4.293444 4.321215 4.34978 4.366314 4.391027 4.402444 4.417346 4.429823 4.441565 4.451327 4.456503 4.464276 4.47449 4.489614 4.499304 4.50768 4.519682 4.530716 4.549262 4.562161 4.576456 4.584549 4.598283 4.61433 4.633223 4.645916 4.660546 4.670505 4.682125 4.685659 4.684013 4.701128 4.713001 4.726238 4.734258 4.747231 4.742282 4.75904 4.77296 4.784668 4.784907 4.798747 4.806773 4.809409 4.807999 4.819097 4.829421 4.838918 4.839314 4.845635 4.846909 4.855524 4.860758 4.86413 4.8676 4.872995 4.872152 4.87677 4.87935 4.879526 4.885741 4.892006 4.888123 4.883643 4.880848 4.894689 4.898091 4.892615 4.88929 4.886023 4.88592 4.883375 4.886963 4.884938 4.887352 4.882902 4.883171 4.877369 4.879913 4.880939 4.886121 4.888932 4.889196 4.901249 4.904449 4.905752 4.913704 4.911504 4.906375 4.911665 4.912401 4.908452 4.897713 4.898496 4.884168 4.875237 4.869408 4.863799 4.874075 4.868367 4.867095 4.872792 4.873638 4.876734 4.873895 4.871532 4.867438 4.874434 4.882051 4.881958 4.88482 4.890045 4.900702 4.913644 4.917039 4.9316 4.93662 4.921361 4.935162 4.939904 4.945359 4.946481 4.946731 4.947812 4.951426 4.952199 4.955771 4.954738 4.958203 4.950125 4.955802 4.964986 4.956616 4.960737 4.966201 4.976188 4.987709 4.992715 4.995261 4.995487 4.999113 5.016857 5.025177 5.035271 5.046762 5.047993 5.046543 5.046186 5.048043 5.044277 5.042867 5.034717 5.027638 5.017683 5.024885 5.015926 5.009268 5.002605 4.982327 4.978362 4.981519 4.981625 4.969276 4.957589 4.955694 4.952236 4.944861 4.941354 4.933261 4.929738 4.932421 4.946521 4.942915 4.940538 4.953249 4.959329 4.959567 4.964187 4.964491 4.965054 4.964668 4.970665 4.988784 4.990673 5.010061 5.023962 5.036636 5.045681 5.058606 5.070796 5.079723 5.080643 5.094493 5.093748 5.108219 5.116293 5.125922 5.136139 5.144617 5.163133 5.176258 5.196383 5.213887 5.236368 5.248635 5.252397 5.271713 5.280052 5.297479 5.303368 5.309464 5.318155 5.330949 5.347307 5.362742 5.372419 5.377205 5.390867 5.401109 5.406177 5.40814 5.424206 5.425489 5.432041 5.433977 5.439831 5.438302 5.449037 5.460009 5.463292 5.466026 5.465256 5.483071 5.480088 5.493475 5.494992 5.503075 5.515515 5.525137 5.531303 5.536322 5.539803 5.534989 5.536864 5.551017 5.557953 5.567627 5.573926 5.577187 5.575965 5.579259 5.589368 5.597477 5.599061 5.613175 5.619317 5.641945 5.65531 5.660106 5.661547 5.663653 5.665462 5.666336 5.667375 5.677234 0.1541 0.243753 0.287331 0.264622 0.250544 0.24368 0.26565 0.272099 0.289083 0.282793 0.309561 0.345801 0.400594 0.460922 0.524133 0.587136 0.651398 0.715186 0.792886 0.882129 0.960928 1.047643 1.139476 1.22399 1.318347 1.41098 1.503627 1.588004 1.678403 1.784546 1.871909 1.946109 2.029009 2.102625 2.176341 2.240431 2.288549 2.347309 2.410439 2.45768 2.493918 2.539809 2.591407 2.640612 2.679867 2.734523 2.793493 2.835679 2.911221 2.958993 3.022893 3.068946 3.122787 3.174528 3.218781 3.261526 3.307793 3.347481 3.389769 3.428291 3.456823 3.479969 3.509582 3.513994 3.533939 3.554909 3.588667 3.624543 3.656184 3.69242 3.727626 3.762314 3.799663 3.836216 3.873853 3.912664 3.948777 3.986967 4.016605 4.025883 4.054768 4.073221 4.087779 4.104743 4.113261 4.116668 4.13564 4.160067 4.171305 4.178692 4.199055 4.229065 4.251791 4.267618 4.277597 4.292351 4.296373 4.324978 4.344858 4.362337 4.377443 4.378651 4.407379 4.420994 4.432728 4.446807 4.454207 4.465142 4.45938 4.450148 4.452931 4.453121 4.464619 4.462022 4.468353 4.469911 4.475871 4.466842 4.46844 4.46647 4.478154 4.479937 4.487486 4.501407 4.5111 4.509368 4.513533 4.518931 4.516363 4.527062 4.530073 4.564195 4.576328 4.580342 4.593655 4.611623 4.619899 4.647005 4.653198 4.657223 4.653759 4.667178 4.672774 4.673498 4.670148 4.668509 4.685177 4.682671 4.692249 4.691817 4.707566 4.707314 4.696589 4.700791 4.706389 4.69899 4.704829 4.714406 4.703057 4.717642 4.725453 4.748085 4.757687 4.763393 4.763321 4.773438 4.773677 4.77639 4.777003 4.773925 4.786438 4.787176 4.78322 4.790965 4.794492 4.800338 4.807305 4.804592 4.809935 4.813975 4.81059 4.815376 4.823335 4.825182 4.838582 4.832934 4.83936 4.841944 4.8531 4.854544 4.86142 4.86352 4.858684 4.855493 4.862028 4.846111 4.848434 4.852448 4.857708 4.856638 4.862537 4.861278 4.878796 4.888959 4.890158 4.894401 4.900334 4.904916 4.906359 4.910932 4.915638 4.912165 4.90524 4.900507 4.900706 4.898817 4.878449 4.876625 4.876747 4.885542 4.889908 4.886808 4.884459 4.884431 4.874839 4.868274 4.865598 4.857587 4.853503 4.85049 4.854852 4.856672 4.876596 4.874134 4.881522 4.889463 4.891958 4.888648 4.895513 4.905635 4.901514 4.900796 4.896982 4.902986 4.904966 4.903302 4.905594 4.887747 4.901641 4.889168 4.89951 4.895283 4.897101 4.901951 4.908118 4.915434 4.92615 4.929303 4.94072 4.952698 4.948281 4.948046 4.94166 4.931209 4.929217 4.941229 4.941792 4.941366 4.936557 4.947864 4.951935 4.944542 4.948687 4.949713 4.95387 4.951571 4.955007 4.962493 4.959445 4.968125 4.967958 4.969217 4.977637 4.972486 4.984478 4.995192 5.006766 5.022906 5.008139 5.021642 5.02554 5.027285 5.030883 5.025632 5.041289 5.065376 5.079109 5.100359 5.140522 5.153928 5.162866 5.18116 5.194556 5.207387 5.219046 5.226441 5.24941 5.268905 5.269557 5.274275 5.282935 5.296361 5.302502 5.314701 5.326084 5.328491 5.32733 5.336678 5.332379 5.330812 5.318102 5.323197 5.324167 5.327452 5.32541 5.347479 5.355659 5.3555 5.360632 5.361345 5.360044 5.359776 5.358818 5.363137 5.377502 5.369374 5.369337 5.377661 5.383324 5.386833 5.390579 5.407866 5.417181 5.412911 5.404356 5.403823 5.395371 5.386008 5.368871 5.378935 5.375738 5.369788 5.372686 5.372942 5.383691 5.369033 5.373013 5.37879 5.391775 5.397184 5.415212";
			IntexWrap instance = new IntexWrap(DataOut);

			System.out.print(DataOut.toString());
			
			KeyVal argOptions = new KeyVal();
			KeyVal argDeal = new KeyVal();
			KeyVal argCF = new KeyVal();
			KeyVal argStats = new KeyVal();

			argOptions.add("CDI_PATH", IntexWrapPkg.CDI_PATH());
			argOptions.add("CDU_PATH", IntexWrapPkg.CDU_PATH());
			argOptions.add("ACCESS_KEYCODE", accessCode);
			argOptions.add("ACCESS_CLIENT", companyName);
			argOptions.add("SETTLE_WITH_CDU_DATE", "CDU_DATE");
			argOptions.add("LOANS_CONTROLS_LIMIT", "0");
			
			argDeal.add("DEAL_NAME", dealName);
			argDeal.add("DEAL_MODE", "NEW");
			argDeal.add("SETTLE_YYYYMMDD", "20140425");

			argCF.add("PREPAY_UNITS", "SMM");
			argCF.add("PREPAY_RATE", prepayCurve);
			argCF.add("LOSS_UNITS", "MDR");
			argCF.add("LOSS_RATE", lossCurve);
			argCF.add("LIBOR_1MO", intRate);
			argCF.add("SCENARIO_TYPE", "DEAL");
			
			argCF.add("OPTREDEEM_FORECAST_METHOD", "BY_EXPRESSION");
			argCF.add("OPTREDEEM_CALL_WHEN[CTAS14C1::CLEANUP]", "ASAP");
			argCF.add("USE_DELINQ_HIST", "HIST_DELINQ_ACTUAL");
			argOptions.add("FULL_CASHFLOW_DETAIL", "FULL");
			
			argStats.add("RUN_TYPE", "CASHFLOWS");
			argStats.add("SHOW_CASHFLOWS_MODE", "FORECASTED");
			argStats.add("TRANCHE_ROW", trancheName);
			
			String retString = instance.deal(argOptions.toString(),
					argDeal.toString());
			String ret2String = instance.cashflow(argOptions.toString(), null,
					argCF.toString(), null, null);
			String ret3String = instance.stats(argOptions.toString(), null,
					ret2String, argStats.toString());
			instance.exit();
			
			System.out
			.println("***********************Deal Output Below***************************************");
			System.out.println(retString);
			System.out
					.println("***********************Cashflow Output Below***************************************");
			System.out.println(ret2String);
			System.out
					.println("***********************Stats Output Below***************************************");
			System.out.println(ret3String);
			

		} catch (IntexWrapParseException e1) {
			System.out.println("Error!:" + e1.toString());
			System.out.println("\n\nDataOut:\n" + e1.getDataOut());
		} catch (IntexWrapException e1) {
			System.out.println("Error!:" + e1.toString());
		}
	}

	public static void main(String args[]) {

		String dealName = "ctas14c2";
		String trancheName = "'1M1','1M2'";
		String prepayCurve = "0  0.480754  0.497671  0.477744  0.483611  0.438892  0.439636  0.407669  0.408054  0.428871  0.431384  0.420938  0.414961  0.386492  0.434794  0.341374  0.379112  0.331851  0.317274  0.283628  0.18779  0.197583  0.195794  0.188704  0.186968  0.17739  0.174605  0.157172  0.15732  0.1394  0.141555  0.129741  0.133387  0.142635  0.143974  0.14341  0.146166  0.142784  0.146559  0.137061  0.141685  0.128978  0.13255  0.123635  0.127852  0.135779  0.136694  0.134048  0.133987  0.128096  0.130298  0.120962  0.123691  0.111504  0.114312  0.105958  0.109153  0.115712  0.115954  0.114478  0.116406  0.113298  0.116776  0.109027  0.112352  0.102365  0.105922  0.098563  0.103276  0.11229  0.115023  0.115885  0.119739  0.117485  0.123131  0.115179  0.121732  0.11114  0.118393  0.110583  0.1134  0.12245  0.122884  0.122489  0.125864  0.121809  0.128564  0.119687  0.127373  0.113611  0.119904  0.110276  0.113782  0.126784  0.130218  0.131383  0.136589  0.133138  0.141365  0.130541  0.13965  0.124269  0.13303  0.122932  0.127199  0.14197  0.144004  0.146193  0.151655  0.147567  0.157098  0.144156  0.154474  0.137828  0.147781  0.134454  0.13768  0.153942  0.157484  0.159573  0.165229  0.16178  0.17124  0.158192  0.168145  0.148725  0.157704  0.143202  0.145964  0.161456  0.163197  0.164071  0.168893  0.163092  0.171784  0.156422  0.165642  0.144537  0.153529  0.138246  0.142056  0.158286  0.160762  0.161436  0.166313  0.16073  0.17034  0.154707  0.164998  0.142845  0.151769  0.135541  0.138597  0.155282  0.157359  0.158622  0.164176  0.15814  0.168494  0.152043  0.163091  0.139748  0.149173  0.13221  0.13582  0.153624  0.156142  0.15743  0.16381  0.157703  0.168918  0.15206  0.163817  0.139116  0.149018  0.130755  0.134627  0.153452  0.156302  0.157832  0.164523  0.158056  0.169895  0.152273  0.164609  0.137878  0.147759  0.128552  0.132929  0.152416  0.154961  0.156568  0.16381  0.157005  0.169556  0.150986  0.164108  0.136252  0.146497  0.126642  0.131698  0.15182  0.154393  0.155932  0.163102  0.156065  0.16891  0.149706  0.162858  0.13369  0.144318  0.123953  0.12895  0.14887  0.151631  0.153379  0.160933  0.153812  0.166876  0.147403  0.160737  0.131198  0.141749  0.120897  0.126584  0.14708  0.149646  0.151429  0.158999  0.151684  0.165165  0.145487  0.158761  0.128559  0.138816  0.118004  0.123416  0.143045  0.14495  0.145546  0.149344  0.142103  0.154421  0.135316  0.147439  0.119007  0.128575  0.109176  0.114446  0.132884  0.134851  0.135463  0.142538  0.135126  0.146068  0.126515  0.138879  0.112044  0.121831  0.103309  0.109267  0.127771  0.130573  0.132712  0.140417  0.134144  0.147108  0.129558  0.142899  0.116101  0.126012  0.10572  0.111145  0.129322  0.131321  0.132407  0.139442  0.131926  0.144037  0.125633  0.137495  0.108721  0.117584  0.097991  0.103455  0.144141  0.147541  0.150421  0.198279  0.189681  0.209837  0.184015  0.204814  0.238331  0.261202  0.218892  0.234467  0.278135  0.285975  0.292056  0.311524  0.29638  0.327818  0.286381  0.3173  0.24848  0.270304  0.22206  0.232667  0.27172  0.274639  0.275361  0.287502  0.265715  0.283808  0.234275  0.237407  0.151528  0.165972  0.137492  0.147805  0.174984  0.178287  0.180611  0.191672  0.180982  0.199558  0.172328  0.190077  0.146522  0.159081  0.129825  0.137877  0.16088  0.160739  0.159429  0.16442  0.149948  0.15832  0.129458  0.133572  0.094526  0.090674  0.0602  0.038731  0.039949  0.032117  0.020919  0.002607  0.002487  0.002666  0.002197  0.002447  0.001925  0.002207  0.001752  0.001657  0.002202  0.002287  0.002341  0.002445  0.002334  0.002503  0.002066  0.002306  0.001813  0.002074  0.001644  0.001552  0.00207  0.002151  0.002202  0.002297  0.002191  0.002353  0.001946  0.002171  0.001711  0.001961  0.001557  0.001476  0.001973  0.002055  0.002106  0.002206  0.00211  0.002268  0.001876  0.002097  0.001652  0.0019  0.001511  0.001433  0.001918  0.001999  0.002052  0.002149  0.002057  0.002217  0.001838  0.002059  0.001625  0.001873  0.00149  0.001416  0.001901  0.001987  0.002048  0.002151  0.002066  0.002237  0.001859  0.002092  0.001658  0.001917  0.001534  0.001465  0.001975  0.002073  0.002146  0.002267  0.002185  0.002375  0.001984  0.002245  0.001791  0.002088  0.001684  0.001621  0.002206  0.002339  0.002447  0.002616  0.00256  0.002826  0.002402  0.002767  0.002251  0.00268  0.002211  0.002186  0.003064  0.003365  0.003662  0.004098  0.004226  0.004963  0.004539  0.005712  0.005181  0.007086  0.00703  0.009013  0.017375  0.018234  0.018757  0.019491  0.018609  0.019973  0.016482  0.01837  0.01442  0.016496  0.013058  0.012326  0.016422  0.017039  0.017403  0.018136  0.017277  0.01851  0.015252  0.016977  0";
		String lossCurve = "0.00000  0.00000  0.00165  0.00452  0.34551  0.12200  0.39342  0.40946  0.41855  0.42381  0.42803  0.42815  0.42756  0.42804  0.46290  0.45518  0.48454  0.49758  0.51092  0.52429  0.53735  0.54906  0.56076  0.56704  0.57267  0.57760  0.58931  0.60039  0.61018  0.62460  0.63819  0.65116  0.65678  0.66115  0.66441  0.65368  0.64255  0.63110  0.62171  0.61276  0.60426  0.59817  0.59216  0.58631  0.57974  0.57257  0.56542  0.55024  0.53508  0.52053  0.51712  0.51397  0.51105  0.50818  0.50545  0.50284  0.49719  0.49099  0.48509  0.47126  0.45811  0.44549  0.44086  0.43635  0.43200  0.42907  0.42609  0.42294  0.41284  0.40236  0.39245  0.37483  0.35778  0.34168  0.33241  0.32388  0.31578  0.30929  0.30305  0.29706  0.28781  0.27843  0.26992  0.26491  0.26050  0.25628  0.25281  0.24967  0.24661  0.24248  0.23814  0.23394  0.22834  0.22326  0.21865  0.21544  0.21233  0.20933  0.20722  0.20516  0.20315  0.20024  0.19737  0.19452  0.19059  0.18685  0.18341  0.18246  0.18149  0.18046  0.17972  0.17898  0.17814  0.17632  0.17439  0.17244  0.16967  0.16703  0.16442  0.16260  0.16077  0.15898  0.15787  0.15677  0.15567  0.15387  0.15199  0.15008  0.14748  0.14493  0.14253  0.14094  0.13941  0.13790  0.13695  0.13603  0.13510  0.13350  0.13181  0.13011  0.12778  0.12548  0.12334  0.12181  0.12033  0.11887  0.11781  0.11678  0.11575  0.11418  0.11254  0.11090  0.10875  0.10665  0.10465  0.10318  0.10176  0.10035  0.09928  0.09823  0.09720  0.09574  0.09422  0.09270  0.09080  0.08894  0.08719  0.08585  0.08456  0.08328  0.08227  0.08130  0.08034  0.07906  0.07774  0.07642  0.07483  0.07330  0.07186  0.07074  0.06966  0.06860  0.06776  0.06694  0.06614  0.06508  0.06398  0.06289  0.06163  0.06042  0.05928  0.05837  0.05749  0.05663  0.05592  0.05523  0.05455  0.05368  0.05278  0.05189  0.05088  0.04992  0.04902  0.04828  0.04757  0.04686  0.04627  0.04570  0.04514  0.04442  0.04368  0.04295  0.04214  0.04136  0.04053  0.03994  0.03937  0.03880  0.03833  0.03787  0.03741  0.03683  0.03623  0.03564  0.03499  0.03437  0.03380  0.03331  0.03284  0.03237  0.03198  0.03160  0.03122  0.03075  0.03026  0.02977  0.02925  0.02874  0.02828  0.02788  0.02750  0.02709  0.02676  0.02644  0.02612  0.02570  0.02530  0.02490  0.02449  0.02409  0.02372  0.02341  0.02282  0.02256  0.02236  0.02213  0.02183  0.02156  0.02127  0.02099  0.02070  0.02042  0.02016  0.01994  0.01973  0.01952  0.01934  0.01916  0.01898  0.01875  0.01876  0.01841  0.01805  0.01770  0.01737  0.01706  0.01676  0.01645  0.01618  0.01590  0.01562  0.01531  0.01500  0.01469  0.01437  0.01407  0.01643  0.01611  0.01579  0.01919  0.01883  0.01847  0.01811  0.01772  0.02541  0.02486  0.02430  0.02376  0.02326  0.02278  0.02229  0.02181  0.02134  0.02087  0.02039  0.01988  0.01935  0.01882  0.01830  0.01753  0.01711  0.01658  0.01604  0.01550  0.01496  0.01442  0.01386  0.01327  0.01100  0.01064  0.01028  0.00993  0.00960  0.00927  0.00894  0.00860  0.00828  0.00795  0.00762  0.00728  0.00694  0.00660  0.00627  0.00593  0.00561  0.00529  0.00496  0.00464  0.00431  0.00398  0.00365  0.00331  0.00298  0.00265  0.00233  0.00149  0.00130  0.00111  0.00084  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000  0.00000";

		CallIntex(dealName,trancheName, prepayCurve, lossCurve);
	}
}
