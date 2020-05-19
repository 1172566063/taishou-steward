package packageMapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import packageModel.StoreCostStructureRecord;
/**
*  @author author
*/
public interface StoreCostStructureRecordBaseMapper {

    int insertStoreCostStructureRecord(StoreCostStructureRecord object);

    int updateStoreCostStructureRecord(StoreCostStructureRecord object);

    int update(StoreCostStructureRecord.UpdateBuilder object);

    List<StoreCostStructureRecord> queryStoreCostStructureRecord(StoreCostStructureRecord object);

    StoreCostStructureRecord queryStoreCostStructureRecordLimit1(StoreCostStructureRecord object);

}