package com.rackspacecloud.blueflood.service;

import com.rackspacecloud.blueflood.io.IMetricsWriter;

public class DummyIngestionService implements IngestionService {

    boolean startServiceCalled = false;
    public boolean getStartServiceCalled() {
        return startServiceCalled;
    }
    ScheduleContext context;
    public ScheduleContext getContext() {
        return context;
    }
    IMetricsWriter writer;
    public IMetricsWriter getWriter() {
        return writer;
    }

    @Override
    public void startService(ScheduleContext context, IMetricsWriter writer) {
        if (startServiceCalled) {
            throw new UnsupportedOperationException("startService was called more than once");
        }
        startServiceCalled = true;
    }

    boolean shutdownServiceCalled = false;
    public boolean getShutdownServiceCalled() {
        return shutdownServiceCalled;
    }

    @Override
    public void shutdownService() {
        if (!startServiceCalled) {
            throw new UnsupportedOperationException("shutdownService was called before startService");
        }
        if (shutdownServiceCalled) {
            throw new UnsupportedOperationException("shutdownService was called more than once");
        }
        shutdownServiceCalled = true;
    }
}
