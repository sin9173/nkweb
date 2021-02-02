import ch.qos.logback.classic.Level

def time = timestamp("HH:mm:ss")
def win_path = "E:/sora_spring/LOGBACK_MALL"
def mac_path="/home/pair/logs/nkwebLog"
def linux_path="/home/pair/logs/nkwebLog"


appender("Console-Appender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss} %msg%n"
    }
}


appender("Controller-Appender", RollingFileAppender) {

    encoder(PatternLayoutEncoder) {
        pattern = "%n====================%n %d{HH:mm:ss} : %msg%n===================="
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern="${mac_path}/"+"info/"+"info-%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
}

appender("Controller-Appender2", RollingFileAppender) {

    encoder(PatternLayoutEncoder) {
        pattern = "%n====================%n %d{HH:mm:ss} : %msg%n===================="
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern="${mac_path}/"+"login/"+"info-%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
}

appender("Error-Appender", RollingFileAppender) {

    encoder(PatternLayoutEncoder) {
        pattern = "%n====================%n %d{HH:mm:ss} : %msg%n===================="
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern="${mac_path}/"+"error/"+"error-%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
}
logger("com.pair.nkweb.controller", INFO, ["Controller-Appender"], false)
logger("com.pair.nkweb.controller2", INFO, ["Controller-Appender2"], false)
logger("com.pair.nkweb.exception", ERROR, ["Error-Appender"], false)
root(TRACE, ["Console-Appender"])
