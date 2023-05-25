package com.zzd.repository.wrapper;

import java.util.List;

import com.zzd.vo.CategoryVO;

/**
 * @author zzd
 * <p>
 * 2018年1月25日
 */
public interface CategoryWrapper {

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
