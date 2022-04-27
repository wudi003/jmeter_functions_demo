package org.apache.jmeter.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * 自定义创建一个不含有 - 的 UUID
 * Create a custom UUID that does not contain “-”
 *
 * Parameters:
 * - None
 *
 * Returns:
 * - A pseudo random UUID 4
 *
 */
public class UuidCustomer extends AbstractFunction {

    private static final List<String> desc = new LinkedList<>();

    //定义 系统函数的名称
    private static final String KEY = "__UUID2"; //$NON-NLS-1$

    public UuidCustomer() {
    }

    //执行的系统函数的操作
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        checkParameterCount(parameters, 0, 0);
    }

    @Override
    public String getReferenceKey() {
        return KEY;
    }

    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }

}
