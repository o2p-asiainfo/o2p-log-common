package com.asiainfo.integration.o2p.log.common.datasource;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ailk.eaap.o2p.common.spring.config.ZKCfgCacheHolder;
import com.ailk.eaap.op2.common.CommonMethodUtil;
import com.ailk.eaap.op2.common.InType;
//
//
///**
// * 类名称 LogServerConstant <br>
// * 日志服务端常用固定变量
// * <p>
// * @version 1.0
// * @author linfeng 2013-2-1
// * <hr>
// * 修改记录
// * <hr>
// * 1、修改人员:    修改时间:<br>       
// *    修改内容:
// * <hr>
// */
public class LogServerConstant {
//	
//	//日志服务端应用的根目录
//	//public static String LOG_SERVER_PROJECT_ABSOLUTE_PATH="";
//	//测试之用
//	//public static String LOG_SERVER_PROJECT_ABSOLUTE_PATH="D:\\Program Files (x86)\\apache-tomcat-6.0.13_eaap\\webapps\\eaap_logServer";
//	public static String LOG_SERVER_PROJECT_ABSOLUTE_PATH="";
//	
//	public static final String LOG_DATA_STATISTICS = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.data.statistics")==null?null:ZKCfgCacheHolder.PROP_ITEMS.get("logserver.data.statistics").toString();
//	
//	public static final String LOG_DATA_EXCEPTION_WRITE_LOG = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.data.exception.writelog");
//	
//	public static final String LOG_START_OSB_ACTIVEMQ = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.start.osb.activemq");
//	
//	public static final String LOGTYPE=ZKCfgCacheHolder.PROP_ITEMS.get("logType");
//
//	public static final String DATABASETYPE = ZKCfgCacheHolder.PROP_ITEMS.get("databaseType");
//	
//	public static final String[] DATABASETYPES = LogServerConstant.DATABASETYPE.split(",");
//	
//	public static final String DATABASE_ORACLE="ORACLE";
//	
//	public static final String DATABASE_MYSQL="MYSQL";
//	
//	public static final String DATABASE_ACTIVEMQ="ACTIVEMQ";
//	
//	//日志服务端在缓存统计
//	public static final Set<String> LOGSERVER_MEMCACHE_KEY = new HashSet<String>();
//	
//	public static final String USE_SEC_PRIFIX="US_";
//	public static final String USE_OTHER_PRIFIX="UO_";
//	public static final String REG_SEC_PRIFIX="RS_";
//	public static final String REG_OTHER_PRIFIX="RO_";
//	public static final String CI_STATS="CI_";
//	public static final String EXP_STATS="EXP_";
//	public static final String CTG_STATS="CTG_";
//	public static final String LOG_STATISTIC_MEMCACHE_RATE=ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic.rate","300");
//	public static final String LOG_STATISTIC_THREAD_START = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.start_statistic_thread");
//	public static final String LOG_STATISTIC_MEMCACHE_KEYS = "memcacheKeys";
//	public static final String LOG_STATIC_CAS_TIMES = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic_cas_times","100");
//	public static final int LOG_STATISTIC_THREAD_NUMBER = Integer.parseInt(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic.thread.number","1"));
//	public static final int LOG_BATCH_NUMBER = Integer.parseInt(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.batch.number","500"));
//	public static final int LOG_MEMCACHE_TTL = Integer.parseInt(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.memcache.ttl","1800"));
//	public static final int LOG_CONTINUE_SCAN_TIME=Integer.parseInt(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.continue.scan.time","2000"));
//	
//	public static final boolean LOG_STATISTIC_LEVEL_SEND=Boolean.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic.level.second","false"));
//	public static final String LOG_STATISTIC_NORMAL_QUEUE="LOG_STATISTIC_NORMAL_QUEUE";
//	public static final String LOG_STATISTIC_EXCEPTION_QUEUE="LOG_STATISTIC_EXCEPTION_QUEUE";
//	public static final String LOG_STATISTIC_CTG_QUEUE="LOG_STATISTIC_CTG_QUEUE";
//	public static final String[] LOG_STATISTIC_QUEUE_ARRAY = {LOG_STATISTIC_NORMAL_QUEUE,LOG_STATISTIC_EXCEPTION_QUEUE,LOG_STATISTIC_CTG_QUEUE};
//	
//	public static final boolean IS_LOGSERVER_STATISTIC_ASYNC = Boolean.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic.async","false"));
//	public static final int  LOG_STATSTIS_THREAD_NUM= Integer.parseInt(ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic.thread.num","5"));
//	        
//	
//	
//	//统计优化测试
//	public static final String LOG_STATISTIC_WAY = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.statistic.way");
//	public static final int FRONT_QUEUE_LENGTH = Integer.parseInt(ZKCfgCacheHolder.PROP_ITEMS.get("front_queue_length","5000"));
//	
//	//front_queue队列长度大小配置
//	public static final String LOG_STORE_WAY = ZKCfgCacheHolder.PROP_ITEMS.get("logserver.store.way"); 
//	//日志写入Hbase相关配置部分
//	public static final String IS_OPEN_SOLR = ZKCfgCacheHolder.PROP_ITEMS.get("is_solr_open","true");
//	
//	public static final String READ_FROM_ACTIVEMQ=ZKCfgCacheHolder.PROP_ITEMS.get("read_from_activemq","false");
//	//日志服务端应用的日志目录名
//	public static final String LOG_SERVER_PROJECT_LOG_DIRECTORY="LOGSERVER";
//	
//	public static final String LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY="ORACLE";
//	
//	public static final String LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY="MYSQL";
//	
//	public static final String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY="ACTIVEMQ";
//	
//	//日志服务端应用的日志对象记录目录名
//	public static final String LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD="RECORD";
//	
//	public static final String LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_WRITE="WRITE";
//	
//	public static final String LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_READ="READ";
//	
//	public static String LOG_SERVER_PROJECT_ABSOLUTE_LOG_DIRECTORY_RECORD="";
//	
//	//日志服务端应用的日志对象超过阀值还是入库失败记录目录名
//	public static final String LOG_SERVER_PROJECT_LOG_DIRECTORY_DOFAIL="DOFAIL";
//	
//	public static String LOG_SERVER_PROJECT_ABSOLUTE_LOG_DIRECTORY_DOFAIL="";
//	
//	//日志服务端应用的日志对象记录完成目录名
//	public static final String LOG_SERVER_PROJECT_LOG_DIRECTORY_FINISHED="FINISHED";	
//	
//	public static String LOG_SERVER_PROJECT_ABSOLUTE_LOG_DIRECTORY_FINISHED="";
//	
//	//完整路径
//	public static String LOG_SERVER_PROJECT_LOG_PATH_DIRECTORY = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//	    //+File.separator
//	    +LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY;
//	
//	public static String LOG_SERVER_PROJECT_LOG_PATH_DIRECTORY_RECORD = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		//+File.separator
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD;
//	
//	public static String LOG_SERVER_PROJECT_LOG_PATH_DIRECTORY_RECORD_READ = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		//+File.separator
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_READ;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_PATH_DIRECTORY_RECORD_WRITE = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		//+File.separator
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_WRITE;
//	
//	public static String LOG_SERVER_PROJECT_LOG_PATH_DIRECTORY_FINISHED = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		//+File.separator
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_FINISHED;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_PATH_DIRECTORY_DOFAIL = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		//+File.separator
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_DOFAIL;
//	
//	//oracle数据库异常日志文件目录
//	public static String LOG_SERVER_PROJECT_LOG_ORALCE_PATH_DIRECTORY = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//	    +LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//	    +File.separator+LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY;
//	
//	public static String LOG_SERVER_PROJECT_LOG_ORALCE_PATH_DIRECTORY_RECORD = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD;
//	
//	public static String LOG_SERVER_PROJECT_LOG_ORALCE_PATH_DIRECTORY_RECORD_READ = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_READ;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_ORALCE_PATH_DIRECTORY_RECORD_WRITE = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_WRITE;
//	
//	public static String LOG_SERVER_PROJECT_LOG_ORALCE_PATH_DIRECTORY_FINISHED = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_FINISHED;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_ORALCE_PATH_DIRECTORY_DOFAIL = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ORACLE_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_DOFAIL;
//	
//	//mysql数据库异常日志文件目录
//	public static String LOG_SERVER_PROJECT_LOG_MYSQL_PATH_DIRECTORY = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//	    +LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//	    +File.separator+LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY;
//	
//	public static String LOG_SERVER_PROJECT_LOG_MYSQL_PATH_DIRECTORY_RECORD = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD;
//	
//	public static String LOG_SERVER_PROJECT_LOG_MYSQL_PATH_DIRECTORY_RECORD_READ = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_READ;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_MYSQL_PATH_DIRECTORY_RECORD_WRITE = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_WRITE;
//	
//	public static String LOG_SERVER_PROJECT_LOG_MYSQL_PATH_DIRECTORY_FINISHED = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_FINISHED;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_MYSQL_PATH_DIRECTORY_DOFAIL = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_MYSQL_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_DOFAIL;
//	
//	//activemq异常日志文件目录
//	public static String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_PATH_DIRECTORY = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//	    +LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//	    +File.separator+LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY;
//	
//	public static String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_PATH_DIRECTORY_RECORD = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD;
//	
//	public static String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_PATH_DIRECTORY_RECORD_READ = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_READ;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_PATH_DIRECTORY_RECORD_WRITE = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_RECORD_WRITE;
//	
//	public static String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_PATH_DIRECTORY_FINISHED = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_FINISHED;	
//	
//	public static String LOG_SERVER_PROJECT_LOG_ACTIVEMQ_PATH_DIRECTORY_DOFAIL = 
//		 LogServerConstant.LOG_SERVER_PROJECT_ABSOLUTE_PATH
//		+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY
//		+File.separator+LOG_SERVER_PROJECT_LOG_ACTIVEMQ_DIRECTORY
//		+File.separator+LogServerConstant.LOG_SERVER_PROJECT_LOG_DIRECTORY_DOFAIL;	
//	
//	
//	//要写入数据的日志文件类型
//	public static final String LOG_DATA_FILE_TYPE_RECORD="RECORD";
//	
//	public static final String LOG_DATA_FILE_TYPE_DOFAIL="DOFAIL";
//	
//	public static final String LOG_DATA_FILE_TYPE_FINISHED="FINISHED";
//	
//	//日志标识符
//	public static final String LOG_DATA_FILE_DOFAIL_PRIFIX="DOFAILLOGMESSAGEOBJECT";	
//	
//	//日志对象标识符
//	public static final String LOG_TYPE_OBJECT_LOGMESSAGEOBJECT="LOGMESSAGEOBJECT";
//	
//	//日志对象子列表标识符
//	public static final String LOG_TYPE_OBJECT_LOGMESSAGEOBJECT_SUBLIST="SUBOBJECTLIST";
//	
//	//日志对象子对象CONTRACT_INTERACTION标识符
//	public static final String LOG_TYPE_OBJECT_CONTRACT_INTERACTION="CONTRACT_INTERACTION";
//	
//	//日志对象子对象ENDPOINT_INTERACTION标识符
//	public static final String LOG_TYPE_OBJECT_ENDPOINT_INTERACTION="ENDPOINT_INTERACTION";
//	
//	//日志对象子对象ORI_LOG_CLOB标识符
//	public static final String LOG_TYPE_OBJECT_ORI_LOG_CLOB="ORI_LOG_CLOB";
//	
//	//日志对象子对象EXCEPTION_LOGS标识符
//	public static final String LOG_TYPE_OBJECT_EXCEPTION_LOGS="EXCEPTION_LOGS";
//	
//	//日志对象子对象CTG_LOGS标识符
//	public static final String LOG_TYPE_OBJECT_CTG_LOGS="CTG_LOGS";	
//	
//	//日志文件中 数据列头符
//	public static final String LOG_DATA_FILE_HEAD="HEAD";
//	
//	//日志文件中 数据行头符
//	public static final String LOG_DATA_FILE_ROW_DATA="ROW_DATA";
//	
//	//日志文件中 数据分隔符
//	public static final String LOG_DATA_FILE_SEPARARE="|#|";
//	
//	//日志文件中  冒号
//	public static final String LOG_DATA_FILE_COLON_SEPARARE=":";
//	
//	//日志文件中  标识空格
//	public static final String LOG_DATA_FILE_SPACE_SEPARARE=" ";
//	
//	public static final String LOG_DATA_FILE_UNDER_LINE_SEPARARE="_";
//	
//	//日志文件中  标识分隔符
//	public static final String LOG_DATA_FILE_ANNOTATION_SEPARARE="#####";
//	
//	//日志文件中 左括号标识
//	public static final String LOG_DATA_FILE_LEFT_SEPARARE="[";
//	
//	//日志文件中 右括号标识
//	public static final String LOG_DATA_FILE_RIGHT_SEPARARE="]";
//	
//	public static final String LOG_DATA_FILE_REPLACE_ENTER_SEPARARE="AAABBBCCC111222333444555666";
//	
//	public static final String LOG_DATA_FILE_REPLACE_LINE_SEPARARE="AAABBBCCCDDDEEEFFF666555444333222111";
//	
//	public static final String LOG_DATA_FILE_REGISTRY_RECORD_REGEX="^(LOGMESSAGEOBJECT_)\\d+(.txt$)";
//	
//	public static final String LOG_DATA_FILE_REGISTRY_DOFAIL_REGEX="^(DOFAILMESSAGEOBJECT_)\\d+(.txt$)";
//	
//	//日志文件中数据批量读取数目
//	public static final int LOG_DATA_BATCH_UPDATE_NUMBER = Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("log_Data_File.batch.read.number"));
//	
//	//日志文件中单条数据插入数据库次数阀值
//	public static final int LOG_DATA_INSERT_DB_FAIL_MAX_TIME = Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("data.insertDB.fail.time"));
//	
//	//日志文件大小
//	public static final int LOG_DATA_FILE_SIZE = Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("log_Data_File.size"));
//	
//	//日志文件是否超过指定大小标识  已满
//	public static final int LOG_DATA_FILE_FULL = 1;
//	
//	//日志文件是否超过指定大小标识  未满
//	public static final int LOG_DATA_FILE_NOT_FULL = 0;
//	
//	public static final String LOG_DATA_FILE_SIZE_SIGN = "SIZE";
//	
//	//日志文件大小单位 字节
//	public static final String LOG_DATA_FILE_SIZE_UNIT_BYTES = "BYTES";
//	
//	//日志文件大小单位 K
//	public static final String LOG_DATA_FILE_SIZE_UNIT_K = "K";
//	
//	//日志文件大小单位 M
//	public static final String LOG_DATA_FILE_SIZE_UNIT_M = "M";
//	
//	public static final String LOG_DATA_FILE_SIZE_TYPE = ZKCfgCacheHolder.PROP_ITEMS.get("log_Data_File.size.type");
//	
//	public static final String FILE_SUFFIX_NAME_TXT=".txt";
//	
//	public static final String FILE_STORAGE_DB_FINISHED_SIGN="FINISHED";
//	
//	public static final String FILE_SUFFIX_NAME_PROPERTIES=".properties";
//	
//	//日志文件数据存放目录
//	public static final String LOG_DATA_FILE_PATH_WINDOW=ZKCfgCacheHolder.PROP_ITEMS.get("path.window");
//	
//	//日志文件数据入库后，将此文件移入完成目录
//	public static final String LOG_DATA_FILE_FINISH_PATH_WINDOW=ZKCfgCacheHolder.PROP_ITEMS.get("finish.path.window");
//	
//	//日志文件 数据开始标识
//	public static final String LOG_DATA_FILE_SIGN_SEGMENT_START="[READ MESSAGEOBJECT START]";
//	
//	//日志文件 添加日志对象编号
//	public static final String LOG_DATA_FILE_SIGN_MESSAGE_OBJECT_NUMBER="RANDOM NUMBER";	
//	
//	//日志文件 记录数据入库次数
//	public static final String LOG_DATA_FILE_SIGN_INSERT_DB_TIMES="INSERT DB TIME";
//	
//	//日志文件 数据结束标识
//	public static final String LOG_DATA_FILE_SIGN_SEGMENT_END="[READ MESSAGEOBJECT END]";
//	
//	//日志文件 消息对象标识
//	public static final String LOG_DATA_FILE_SIGN_MESSAGEOBJECT="MESSAGEOBJECT";
//	
//	public static final String MAP_KEY_TOTALLINE="TOTALLINE";
//	
//	public static final String MAP_KEY_FINISHEDLINE="FINISHEDLINE";
//	
//	public static final String MAP_KEY_LOGOBJECTLIST="LOGOBJECTLIST";
//	
//	public static final String MAP_KEY_LOGMESSAGEOBJECTLIST="LOGMESSAGEOBJECTLIST";
//	
//	public static final String MAP_KEY_BATCHNUMBER="BATCHNUMBER";
//	
//	
//	//数据库表名
//	public static final String TABLE_DATA_SOURCE_ROUTE = "TABLE_DATA_SOURCE_ROUTE";
//	
//	public static final String TABLE_DATA_SOURCE = "TABLE_DATA_SOURCE";
//	
//	//缓存监控线程休眠时间
//	public static final Long LOADCACHE_SLEEP_TIME
//		=Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("loadCache.sleeptime")).longValue();	
//	
//	//队列名
//	//前端接收数据队列
//	public static final String LOG_SERVER_FRONT_DATA_QUEUE_NAME="FRONTSTORAGEQUEUE";
//	
//	//后端从日志文件读取数据放入的数据队列
//	public static final String LOG_SERVER_BACKGROUND_DATA_QUEUE_NAME="BACKGROUNDSTORAGEQUEUE";
//	
//	//后端日志文件队列(用于读写)
//	public static final String LOG_SERVER_FILE_QUEUE_NAME="FILEQUEUE";	
//	
//	//日志文件所处的状态
//	public static final String LOG_DATA_FILE_STATE_DEFAULT="DEFAULT";
//	
//	public static final String LOG_DATA_FILE_STATE_READ="READ";
//	
//	public static final String LOG_DATA_FILE_STATE_WRITE="WRITE";
//	
//	public static final String LOG_DATA_FILE_STATE_INQUEUE="INQUEUE";
//	
//	//日志写文件中的属性文件名
//	public static final String LOG_DATA_FILE_WRITE_PROPERTIES_FILE_NAME="WRITE";
//	
//	public static final String LOG_DATA_FILE_READ_PROPERTIES_FILE_NAME="READ";
//	
//	public static final String LOG_DATA_FILE_DOFAIL_PROPERTIES_FILE_NAME="DOFAIL";
//	
//	//日志写文件中的属性
//	public static final String LOG_DATA_FILE_CURRENT_WRITE_FILE="current.write.file.name";
//	
//	public static final String LOG_DATA_FILE_CURRENT_WRITE_FILE_SIZE="current.write.file.size";
//	
//	public static final String LOG_DATA_FILE_CURRENT_WRITE_FILE_SEQUENCE="current.write.file.sequence";
//	
//	//超过多次入库失败后日志写文件中的属性
//	public static final String LOG_DATA_FILE_CURRENT_DOFAIL_FILE="current.dofail.file.name";
//	
//	public static final String LOG_DATA_FILE_CURRENT_DOFAIL_FILE_SIZE="current.dofail.file.size";
//	
//	public static final String LOG_DATA_FILE_CURRENT_DOFAIL_FILE_SEQUENCE="current.dofail.file.sequence";	
//	
//	//当成记录的日志文件超过时间，但仍到达到指定大小，同样作入库操作
//	public static final String LOG_DATA_FILE_OUT_OF_DATE_TYPE=ZKCfgCacheHolder.PROP_ITEMS.get("logdatafile.outofdatetype");
//	
//	public static final int LOG_DATA_FILE_OUT_OF_DATE
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("logfile.outofdata","0")).intValue();
//	
//	//线程数 	
//	//oracle线程
//	public static final int LOG_SERVER_ORACLE_FRONTQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("oracle.frontQueueThread.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_ORACLE_BACKGROUNDQUEUE_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("oracle.backGroundQueue.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_ORACLE_BACKGROUNDQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("oracle.backGroundQueue.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_ORACLE_FILEQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("oracle.fileQueueThread.number","0")).intValue();		
//	
//	//mysql线程
//	public static final int LOG_SERVER_MYSQL_FRONTQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("mysql.frontQueueThread.number","0")).intValue();
//	
//	public static final int LOG_SERVER_MYSQL_BACKGROUNDQUEUE_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("mysql.backGroundQueue.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_MYSQL_BACKGROUNDQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("mysql.backGroundQueue.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_MYSQL_FILEQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("mysql.fileQueueThread.number","0")).intValue();	
//	
//	//activemq线程
//	public static final int LOG_SERVER_ACTIVEMQ_FRONTQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("activemq.producer.frontQueueThread.number","0")).intValue();
//
//	public static final int LOG_SERVER_ACTIVEMQ_BACKGROUNDQUEUE_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("activemq.producer.backGroundQueue.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_ACTIVEMQ_BACKGROUNDQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("activemq.producer.backGroundQueue.number","0")).intValue();	
//	
//	public static final int LOG_SERVER_ACTIVEMQ_FILEQUEUETHREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("activemq.producer.fileQueueThread.number","0")).intValue();
//		
//	public static final int LOG_SERVER_ACTIVEMQ_CONSUMER_RECEIVETIME
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("activemq.consumer.receivetime")).intValue();
//	
//	public static final int LOG_SERVER_ACTIVEMQ_CONSUMER_THREAD_NUMBER
//		=Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("activemq.consumer.thread.number","1")).intValue();	
//	
//	
//	public static final int LOG_EXCEPTION_DEAL_ACTIVEMQ_CONSUMER_THREAD_NUM 
//	    =Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("dealException.thread.num","1")).intValue();
//	
//	public static final long LOG_DEAL_EXCEPTION_THREAD_SLEEP_TIME 
//	  = Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("dealException.thread.sleepTime","300")).longValue();
//	public static final long LOG_DEAL_EXCEPTION_CONSUMER_RECIEVEOUT_TIME 
//    = Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("dealException.thread.receiveTime","1000")).longValue();
//	
//	public static final int LOG_RETRYEXCEPTION_DEAL_ACTIVEMQ_CONSUMER_THREAD_NUM 
//    =Integer.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("rertydealException.thread.num","1")).intValue();
//	
//	public static final long LOG_DEAL_RETRYEXCEPTION_THREAD_SLEEP_TIME 
//	= Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("rertydealException.thread.sleepTime","300")).longValue();
//	public static final long LOG_DEAL_RETRYEXCEPTION_CONSUMER_RECIEVEOUT_TIME 
//	= Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("rertydealException.thread.receiveTime","1000")).longValue();
//
//	
//	//线程休眠时间 	
//	public static final Long LOG_SERVER_QUEUETHREAD_SLEEP_TIME
//			=Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("queueThread.sleeptime")).longValue();
//	
//	public static final Long LOG_SERVER_FRONTQUEUETHREAD_SLEEP_TIME
//			=Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("frontQueueThread.sleeptime")).longValue();	
//	
//	public static final Long LOG_SERVER_INFILEQUEUETHREAD_SLEEP_TIME
//			=Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("inFileQueueThread.sleeptime")).longValue();	
//	
//	public static final Long LOG_SERVER_OUTFILEQUEUETHREAD_SLEEP_TIME
//			=Long.valueOf(ZKCfgCacheHolder.PROP_ITEMS.get("outFileQueueThread.sleeptime")).longValue();
//	
//	//跟数据源选择相关
//	//数据源路由，线程变量中保存数据源名的ContextName
	public static final String DepDataSourceContextName = "DepDataSource";
//	
//	//数据源路由，线程变量中保存的内部变易流水
//	public static final String CiiContextName = "cii";	
//	
//	//数据源路由，线程变量中保存物理表名的ContextName
//	public static final String DepTabSuffixContextName = "DepTabSuffix";
//	
//	//SQL语句中，物理表名编写方式
//	public static final String DepTabSuffixSQLPattern = "\\$\\{DepTabSuffix\\}";
//	
//	//日志统计
//	//统计时间类型
//	public static final String STATIC_TIME_TYPE_SECOND = "0";
//	
//	public static final String STATIC_TIME_TYPE_MINUTE = "1";
//	
//	public static final String STATIC_TIME_TYPE_HOUR = "2";
//	
//	public static final String STATIC_TIME_TYPE_DAY = "3";
//	
//	public static final String STATIC_TIME_TYPE_WEEK = "4";
//	
//	public static final String STATIC_TIME_TYPE_MONTH = "5";
//	
//	public static final String STATIC_TIME_TYPE_QUARTER = "6";
//	
//	public static final String STATIC_TIME_TYPE_YEAR = "7";
//	
//	//异常业务统计
//	public static final String EXCEPTION_BUSSINESS_BIZ_CODE = "BUSExce1";
//	
//	public static final String EXCEPTION_BUSSINESS_INTF_CODE = "Exception";
//	
//	public static final String EXCEPTION_BUSSINESS_BIZ_INTF_CODE = "Exception";
//	
//	public static final String EXCEPTION_BUSSINESS_REG_SER_VERSION = "Exception1.0";
//	
//	public static final String EXCEPTION_BUSSINESS_CONTRACT_VERSION= "Exception1.0";
//	
//	public static final String EXCEPTION_BUSSINESS_SYS_CODE = "1000000000";
//	
//	//系统异常统计
//	public static final String EXCEPTION_SYSTEM_BIZ_CODE = "BUSErro1";
//	
//	public static final String EXCEPTION_SYSTEM_INTF_CODE = "ERROR";
//	
//	public static final String EXCEPTION_SYSTEM_BIZ_INTF_CODE = "ERROR";
//	
//	public static final String EXCEPTION_SYSTEM_REG_SER_VERSION = "ERROR1.0";
//	
//	public static final String EXCEPTION_SYSTEM_CONTRACT_VERSION = "ERROR1.0";
//	
//	public static final String EXCEPTION_SYSTEM_SYS_CODE = "2000000000";	
//	
//	
//	//日志文件  服务/协议交互实例表列头串
//	public static final String LOG_DATA_FILE_HEAD_CONTRACT_INTERACTION =
//			 "CONTRACT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"BIZ_FUNC_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"BIZ_INTF_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CONTRACT_VERSION"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"REG_SER_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"REG_SER_VERSION"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SERVICE_LEVEL"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_ORG_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_ORG_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_SYS_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_SYS_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"TEST_FLAG"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_REQ_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CENTER_REC_REQ_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CENTER_FWD_2_DST_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_REC_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_REPLY_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CENTER_REC_DST_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CENTER_FWD_2_SRC_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_CONFIRM_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_RESPONSE_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"RESPONSE_TYPE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"RESPONSE_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"RESPONSE_DES"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CREATE_TIME";
//	
//	//日志文件  端点记录表列头串
//	public static final String LOG_DATA_FILE_HEAD_ENDPOINT_INTERACTION =
//			 "ENDPOINT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CONTRACT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SERVICE_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"ENDPOINT_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CREATE_DATE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"REQ_OR_RES"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"QUEUE_MSG_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"RES_QUEUE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"REQ_QUEUE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_ORG_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_SYS_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CENTER_FWD_2_DST_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_REPLY_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DESCRIPTOR";	
//	
//	//日志文件  原始CLOB日志表列头串
//	public static final String LOG_DATA_FILE_HEAD_ORI_LOG_CLOB =
//			 "ENDPOINT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CONTRACT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"ENDPOINT_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_ORG_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_SYS_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_ORG_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DST_SYS_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_IP"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"REQ_OR_RES"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"MSG"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CREATE_TIME";		
//	
//	//日志文件  异常记录表列头串
//	public static final String LOG_DATA_FILE_HEAD_EXCEPTION_LOGS =
//			 "EXCEPTION_SPEC_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CONTRACT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"SRC_TRAN_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CREATE_TIME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"EXCEPTION_MESSAGE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CONTENT"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"STAFF_NBR";
//	
//	//日志文件  内部程序异常日志表列头串
//	public static final String LOG_DATA_FILE_HEAD_CTG_LOGS =
//			 "CONTRACT_INTERACTION_ID"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"ERR_CODE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"FUN_NAME"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"CREATE_DATE"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"ERROR_MSG"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"DESCRIPTOR"+LogServerConstant.LOG_DATA_FILE_SEPARARE
//			+"STATUS";	
//	
	public static final Map<String,String> KEY_MAP = new HashMap<String,String>();
	static{
		KEY_MAP.put(InType.APINAME, "API_NAME");
		KEY_MAP.put(InType.APPKEY, "APP_KEY");
		KEY_MAP.put(InType.SrcSysCode, "SRC_SYS_CODE");
		KEY_MAP.put(InType.ReqTime, "REQ_TIME");
		KEY_MAP.put(InType.DstSysID, "DST_SYS_ID");
		KEY_MAP.put(InType.Format, "FORMAT");
		KEY_MAP.put(InType.TRANSID, "TRANSID");
		KEY_MAP.put(InType.Method, "METHOD");
		KEY_MAP.put(InType.BusiCode, "BUS_CODE");
		KEY_MAP.put(InType.AccessToken, "ACCESS_TOKEN");
		KEY_MAP.put(InType.ServiceContractVer, "SVC_CONTRACT_VER");
		KEY_MAP.put(InType.IP, "IP");
		KEY_MAP.put(InType.Sign, "SIGN");
		KEY_MAP.put("srcSysSign", "SRC_SYS_SIGN");
		KEY_MAP.put("tenantId", "TENANT_ID");
	}
	
}