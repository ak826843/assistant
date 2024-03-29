package idv.hsiehpinghan.xbrlassistant.xbrl;

public class Presentation {
	public static class Id {
		public static final String AccountantsReport = "http://www.xbrl.org/tifrs/ar/role/AccountantsReport";
		public static final String BalanceSheet = "http://www.xbrl.org/tifrs/fr/role/BalanceSheet";
		public static final String StatementOfComprehensiveIncome = "http://www.xbrl.org/tifrs/fr/role/StatementOfComprehensiveIncome";
		public static final String StatementOfChangesInEquity = "http://www.xbrl.org/tifrs/fr/role/StatementOfChangesInEquity";
		public static final String StatementOfCashFlows = "http://www.xbrl.org/tifrs/fr/role/StatementOfCashFlows";
		public static final String FinancialStatementsNotes = "http://www.xbrl.org/tifrs/notes/role/FinancialStatementsNotes";
		public static final String HistoryAndOrganization = "http://www.xbrl.org/tifrs/notes/role/HistoryAndOrganization";
		public static final String DateAndProceduresOfAuthorisationForIssueOfFinancialStatements = "http://www.xbrl.org/tifrs/notes/role/DateAndProceduresOfAuthorisationForIssueOfFinancialStatements";
		public static final String ApplicationOfNewlyIssuedOrAmendedStandardsAndInterpretations = "http://www.xbrl.org/tifrs/notes/role/ApplicationOfNewlyIssuedOrAmendedStandardsAndInterpretations";
		public static final String SummaryOfSignificantAccountingPolicies = "http://www.xbrl.org/tifrs/notes/role/SummaryOfSignificantAccountingPolicies";
		public static final String SourcesOfUncertaintyFromSignificantAccountingJudgmentsAssumptionsAndEstimations = "http://www.xbrl.org/tifrs/notes/role/SourcesOfUncertaintyFromSignificantAccountingJudgmentsAssumptionsAndEstimations";
		public static final String DisclosureOfGeneralInformationAboutFinancialStatements = "http://www.xbrl.org/tifrs/role/DisclosureOfGeneralInformationAboutFinancialStatements";
		public static final String LoansToOthers = "http://www.xbrl.org/tifrs/notes/role/LoansToOthers";
		public static final String EndorsementGuaranteeProvidedToOthers = "http://www.xbrl.org/tifrs/notes/role/EndorsementGuaranteeProvidedToOthers";
		public static final String NamesLocationsAndRelatedInformationOfInvesteesOverWhichTheCompanyExercisesSignificantInfluence = "http://www.xbrl.org/tifrs/notes/role/NamesLocationsAndRelatedInformationOfInvesteesOverWhichTheCompanyExercisesSignificantInfluence";
		public static final String InvestmentInMainlandChina = "http://www.xbrl.org/tifrs/notes/role/InvestmentInMainlandChina";
	}

	public static class Attribute {
		public static final String ORDER = "order";
		public static final String CHINESE_LABEL = "chinese_label";
		public static final String ENGLISH_LABEL = "english_label";
		public static final String VALUES = "values";
		public static final String VALUE = "value";
		public static final String UNIT = "unit";
		public static final String PERIOD_TYPE = "periodType";
		public static final String INSTANT = "instant";
		public static final String START_DATE = "startDate";
		public static final String END_DATE = "endDate";
	}

	public static class Unit {
		public static final String TWD = "TWD";
		public static final String SHARES = "Shares";
	}

	public static class ElementId {
		// BalanceSheet
		public static final String CURRENT_ASSETS = "ifrs_CurrentAssets";
		public static final String NONCURRENT_ASSETS = "ifrs_NoncurrentAssets";
		public static final String CURRENT_LIABILITIES = "ifrs_CurrentLiabilities";
		public static final String NONCURRENT_LIABILITIES = "ifrs_NoncurrentLiabilities";
		public static final String EQUITY = "ifrs_Equity";

		// StatementOfComprehensiveIncome
		public static final String GROSS_PROFIT_LOSS_FROM_OPERATIONS_NET = "tifrs-bsci-ci_GrossProfitLossFromOperationsNet";
		public static final String NET_OPERATING_INCOME_LOSS = "tifrs-bsci-ci_NetOperatingIncomeLoss";
		public static final String NONOPERATING_INCOME_AND_EXPENSES = "tifrs-bsci-ci_NonoperatingIncomeAndExpenses";
		public static final String INCOME_TAX_EXPENSE_CONTINUING_OPERATIONS = "ifrs_IncomeTaxExpenseContinuingOperations";
		public static final String PROFIT_LOSS_FROM_CONTINUING_OPERATIONS = "ifrs_ProfitLossFromContinuingOperations";
		public static final String DILUTED_EARNINGS_LOSS_PER_SHARE = "ifrs_DilutedEarningsLossPerShare";
		
		// Statement Of Cash Flows
		public static final String CASH_FLOWS_FROM_USED_IN_OPERATING_ACTIVITIES = "ifrs_CashFlowsFromUsedInOperatingActivities";
		public static final String NET_CASH_FLOWS_FROM_USED_IN_INVESTING_ACTIVITIES = "tifrs-SCF_NetCashFlowsFromUsedInInvestingActivities";
		public static final String CASH_FLOWS_FROM_USED_IN_FINANCING_ACTIVITIES = "tifrs-SCF_CashFlowsFromUsedInFinancingActivities";

		// StatementOfChangesInEquity
		public static final String PROFIT_LOSS = "ifrs_ProfitLoss";
		public static final String OTHER_COMPREHENSIVE_INCOME = "ifrs_OtherComprehensiveIncome";
	}
}
