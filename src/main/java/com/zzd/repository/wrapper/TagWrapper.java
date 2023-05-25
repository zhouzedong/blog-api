package com.zzd.repository.wrapper;

import java.util.List;

import com.zzd.vo.TagVO;

/**
 * @author zzd
 * <p>
 * 2018年1月25日
 */
public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
