package com.yjy.admin.module.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yjy.common.entity.BaseEntity;
import com.yjy.common.enums.CommonStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * 
 * @since 2019-03-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("qrtz_quartz_job")
public class QuartzJob extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String cronExpression;

    private String description;

    private String jobClassName;

    private String parameter;

    private Integer status = CommonStatus.STATUS_ENABLED.getStatus();
}
