#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import org.disl.meta.Description
import org.disl.sample.dataModel.common.TargetTable;
import org.disl.sample.dataModel.domains.Amount
import org.disl.sample.dataModel.domains.Id
import org.disl.sample.dataModel.domains.Name

@Description("Table description")
class ${NAME} extends TargetTable {
	@Description("Column SMTH_ID description.")	
	Id SMTH_ID
	
	@Description("Column SMTH_NAME description.")
	Name SMTH_NAME
	
	@Description("Column SMTH_AMOUNT description.")
	Amount SMTH_AMOUNT
}
