package com.incompetent.tester.automation.events;

/**
 * Enum is used to get wait time either from User
 */
public enum WaitTime {
    MAX_SECONDS {
        @Override
        public int getWaitTime() {
            return getUserWaitTime("maxWaitTime", 60);
        }
    }, POLLING_IN_EVERY {
        @Override
        public int getWaitTime() {
            return getUserWaitTime("pollingTime", 2);
        }
    };

    public abstract int getWaitTime();

    int getUserWaitTime(String varName, int defaultTime) {
        if (System.getProperty(varName) == null && System.getenv(varName) == null) {
            return 60;
        } else {
            String waitTime = System.getProperty(varName) == null ? System.getenv(varName) : System.getProperty(varName);
            return Integer.parseInt(waitTime);
        }
    }
}
