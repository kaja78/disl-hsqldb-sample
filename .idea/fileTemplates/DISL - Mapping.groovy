#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import org.disl.meta.Description

import static org.disl.sample.dataMapping.library.ExpressionLibrary.*

import org.disl.meta.ColumnMapping
import org.disl.sample.dataMapping.common.LoadTargetTableMapping

@Description("Load ${NAME} description.")
class ${NAME} extends LoadTargetTableMapping {
	
	TGT_TABLE target
	
	SRC_TABLE src

	@Override
	public void initMapping() {
		from src
        where """1=1"""        
	}
	
}