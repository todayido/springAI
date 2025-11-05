package demoStudy.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * GmTestMessage model representing all fields from gm-test-mappings.json
 */
public class GmTestMessage {
    // Join field
    private String myJoinField;
    
    // File related fields
    private String fileCode;
    private String realmd5;
    private Byte simFileFlag;
    private String simFileCode;
    private String sim;
    
    // Content fields
    private String nameCode;
    private String name;
    private String summaryCode;
    private String summary;
    private String textCode;
    private String text;
    private Long textLength;
    
    // File metadata
    private String uuid;
    private String filesize;
    private String recordCount;
    private String redhead;
    private Byte type;
    private Byte importFlag;
    private String feature;
    private String keyWord;
    
    // Level and check fields
    private Byte level;
    private Byte oldLevel;
    private String preCheckComment;
    private String preCheckFlag;
    private String action;
    
    // Date fields
    private Date createDate;
    private Date filecreatetime;
    private Date filemodifytime;
    
    // Location fields
    private String srcLocation;
    private String destLocation;
    
    // User fields
    private String userId;
    private String userName;
    
    // Computer fields
    private String computerId;
    private String computerName;
    private String computerLocation;
    
    // Network fields
    private String srcip;
    private Long srcport;
    private String srcterminal;
    private String dstip;
    private Long dstport;
    private String dstterminal;
    private String ip;
    private String mac;
    private String sn;
    
    // Organization fields
    private String orgId;
    private String orgPath;
    private String policyId;
    private String version;
    
    // Status fields
    private Byte readFlag;
    private Byte sendFlag;
    private Date sendTime;
    private Short signFlag;
    private Byte deleteFlag;
    private Date deleteTime;
    
    // Judge fields
    private Byte judgeFlag;
    private String mgLevel;
    private Date judgeTime;
    private Date updateTime;
    private String judgeAccountId;
    private String judgeAccountName;
    private String judgeAccountRoleId;
    private Byte judgeAccountType;
    
    // Pre-judge fields
    private String preJudgeAccountId;
    private String preJudgeAccountName;
    private Byte preJudgeAccountType;
    private String preJudgeLevel;
    private Date preJudgeTime;
    private Byte preJudgeFlag;
    private String judgeActionText;
    
    // Additional fields
    private Byte shareType;
    private String deduction;
    private String hostId;
    private Integer reportId;
    private Integer rid;
    private Integer taskId;
    private String usermanager;
    private String application;
    private String attriute;
    private Integer code;
    private String contentKeyword;
    private String copymd5;
    private String accessTime;
    private String deleted;
    private Integer priority;
    private String mcKeywordHit;
    private String nameKeyword;
    private String scope;
    private String trust;
    private String fileName;
    
    // Count fields
    private Integer okNum;
    private Integer juemiNum;
    private Integer jimiNum;
    private Integer mimiNum;
    private Integer fileIndex;
    
    // Additional technical fields
    private String logicFileCode;
    private String srcvid;
    private String srcpid;
    private String dstvid;
    private String dstpid;
    private Byte computerStatus;
    private Byte isFileDelete;
    private String server;
    private String reverseId;
    private Integer confirmStatus;
    private Integer suspectNum;
    private String classifiedDesc;
    private Long rangeTime;

    // Default constructor
    public GmTestMessage() {
    }

    // Getters and Setters
    public String getMyJoinField() {
        return myJoinField;
    }

    public void setMyJoinField(String myJoinField) {
        this.myJoinField = myJoinField;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getRealmd5() {
        return realmd5;
    }

    public void setRealmd5(String realmd5) {
        this.realmd5 = realmd5;
    }

    public Byte getSimFileFlag() {
        return simFileFlag;
    }

    public void setSimFileFlag(Byte simFileFlag) {
        this.simFileFlag = simFileFlag;
    }

    public String getSimFileCode() {
        return simFileCode;
    }

    public void setSimFileCode(String simFileCode) {
        this.simFileCode = simFileCode;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummaryCode() {
        return summaryCode;
    }

    public void setSummaryCode(String summaryCode) {
        this.summaryCode = summaryCode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTextCode() {
        return textCode;
    }

    public void setTextCode(String textCode) {
        this.textCode = textCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTextLength() {
        return textLength;
    }

    public void setTextLength(Long textLength) {
        this.textLength = textLength;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(String recordCount) {
        this.recordCount = recordCount;
    }

    public String getRedhead() {
        return redhead;
    }

    public void setRedhead(String redhead) {
        this.redhead = redhead;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Byte importFlag) {
        this.importFlag = importFlag;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getOldLevel() {
        return oldLevel;
    }

    public void setOldLevel(Byte oldLevel) {
        this.oldLevel = oldLevel;
    }

    public String getPreCheckComment() {
        return preCheckComment;
    }

    public void setPreCheckComment(String preCheckComment) {
        this.preCheckComment = preCheckComment;
    }

    public String getPreCheckFlag() {
        return preCheckFlag;
    }

    public void setPreCheckFlag(String preCheckFlag) {
        this.preCheckFlag = preCheckFlag;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFilecreatetime() {
        return filecreatetime;
    }

    public void setFilecreatetime(Date filecreatetime) {
        this.filecreatetime = filecreatetime;
    }

    public Date getFilemodifytime() {
        return filemodifytime;
    }

    public void setFilemodifytime(Date filemodifytime) {
        this.filemodifytime = filemodifytime;
    }

    public String getSrcLocation() {
        return srcLocation;
    }

    public void setSrcLocation(String srcLocation) {
        this.srcLocation = srcLocation;
    }

    public String getDestLocation() {
        return destLocation;
    }

    public void setDestLocation(String destLocation) {
        this.destLocation = destLocation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerLocation() {
        return computerLocation;
    }

    public void setComputerLocation(String computerLocation) {
        this.computerLocation = computerLocation;
    }

    public String getSrcip() {
        return srcip;
    }

    public void setSrcip(String srcip) {
        this.srcip = srcip;
    }

    public Long getSrcport() {
        return srcport;
    }

    public void setSrcport(Long srcport) {
        this.srcport = srcport;
    }

    public String getSrcterminal() {
        return srcterminal;
    }

    public void setSrcterminal(String srcterminal) {
        this.srcterminal = srcterminal;
    }

    public String getDstip() {
        return dstip;
    }

    public void setDstip(String dstip) {
        this.dstip = dstip;
    }

    public Long getDstport() {
        return dstport;
    }

    public void setDstport(Long dstport) {
        this.dstport = dstport;
    }

    public String getDstterminal() {
        return dstterminal;
    }

    public void setDstterminal(String dstterminal) {
        this.dstterminal = dstterminal;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Byte getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Byte readFlag) {
        this.readFlag = readFlag;
    }

    public Byte getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Byte sendFlag) {
        this.sendFlag = sendFlag;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Short getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Short signFlag) {
        this.signFlag = signFlag;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Byte getJudgeFlag() {
        return judgeFlag;
    }

    public void setJudgeFlag(Byte judgeFlag) {
        this.judgeFlag = judgeFlag;
    }

    public String getMgLevel() {
        return mgLevel;
    }

    public void setMgLevel(String mgLevel) {
        this.mgLevel = mgLevel;
    }

    public Date getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(Date judgeTime) {
        this.judgeTime = judgeTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getJudgeAccountId() {
        return judgeAccountId;
    }

    public void setJudgeAccountId(String judgeAccountId) {
        this.judgeAccountId = judgeAccountId;
    }

    public String getJudgeAccountName() {
        return judgeAccountName;
    }

    public void setJudgeAccountName(String judgeAccountName) {
        this.judgeAccountName = judgeAccountName;
    }

    public String getJudgeAccountRoleId() {
        return judgeAccountRoleId;
    }

    public void setJudgeAccountRoleId(String judgeAccountRoleId) {
        this.judgeAccountRoleId = judgeAccountRoleId;
    }

    public Byte getJudgeAccountType() {
        return judgeAccountType;
    }

    public void setJudgeAccountType(Byte judgeAccountType) {
        this.judgeAccountType = judgeAccountType;
    }

    public String getPreJudgeAccountId() {
        return preJudgeAccountId;
    }

    public void setPreJudgeAccountId(String preJudgeAccountId) {
        this.preJudgeAccountId = preJudgeAccountId;
    }

    public String getPreJudgeAccountName() {
        return preJudgeAccountName;
    }

    public void setPreJudgeAccountName(String preJudgeAccountName) {
        this.preJudgeAccountName = preJudgeAccountName;
    }

    public Byte getPreJudgeAccountType() {
        return preJudgeAccountType;
    }

    public void setPreJudgeAccountType(Byte preJudgeAccountType) {
        this.preJudgeAccountType = preJudgeAccountType;
    }

    public String getPreJudgeLevel() {
        return preJudgeLevel;
    }

    public void setPreJudgeLevel(String preJudgeLevel) {
        this.preJudgeLevel = preJudgeLevel;
    }

    public Date getPreJudgeTime() {
        return preJudgeTime;
    }

    public void setPreJudgeTime(Date preJudgeTime) {
        this.preJudgeTime = preJudgeTime;
    }

    public Byte getPreJudgeFlag() {
        return preJudgeFlag;
    }

    public void setPreJudgeFlag(Byte preJudgeFlag) {
        this.preJudgeFlag = preJudgeFlag;
    }

    public String getJudgeActionText() {
        return judgeActionText;
    }

    public void setJudgeActionText(String judgeActionText) {
        this.judgeActionText = judgeActionText;
    }

    public Byte getShareType() {
        return shareType;
    }

    public void setShareType(Byte shareType) {
        this.shareType = shareType;
    }

    public String getDeduction() {
        return deduction;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getUsermanager() {
        return usermanager;
    }

    public void setUsermanager(String usermanager) {
        this.usermanager = usermanager;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAttriute() {
        return attriute;
    }

    public void setAttriute(String attriute) {
        this.attriute = attriute;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContentKeyword() {
        return contentKeyword;
    }

    public void setContentKeyword(String contentKeyword) {
        this.contentKeyword = contentKeyword;
    }

    public String getCopymd5() {
        return copymd5;
    }

    public void setCopymd5(String copymd5) {
        this.copymd5 = copymd5;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getMcKeywordHit() {
        return mcKeywordHit;
    }

    public void setMcKeywordHit(String mcKeywordHit) {
        this.mcKeywordHit = mcKeywordHit;
    }

    public String getNameKeyword() {
        return nameKeyword;
    }

    public void setNameKeyword(String nameKeyword) {
        this.nameKeyword = nameKeyword;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTrust() {
        return trust;
    }

    public void setTrust(String trust) {
        this.trust = trust;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getOkNum() {
        return okNum;
    }

    public void setOkNum(Integer okNum) {
        this.okNum = okNum;
    }

    public Integer getJuemiNum() {
        return juemiNum;
    }

    public void setJuemiNum(Integer juemiNum) {
        this.juemiNum = juemiNum;
    }

    public Integer getJimiNum() {
        return jimiNum;
    }

    public void setJimiNum(Integer jimiNum) {
        this.jimiNum = jimiNum;
    }

    public Integer getMimiNum() {
        return mimiNum;
    }

    public void setMimiNum(Integer mimiNum) {
        this.mimiNum = mimiNum;
    }

    public Integer getFileIndex() {
        return fileIndex;
    }

    public void setFileIndex(Integer fileIndex) {
        this.fileIndex = fileIndex;
    }

    public String getLogicFileCode() {
        return logicFileCode;
    }

    public void setLogicFileCode(String logicFileCode) {
        this.logicFileCode = logicFileCode;
    }

    public String getSrcvid() {
        return srcvid;
    }

    public void setSrcvid(String srcvid) {
        this.srcvid = srcvid;
    }

    public String getSrcpid() {
        return srcpid;
    }

    public void setSrcpid(String srcpid) {
        this.srcpid = srcpid;
    }

    public String getDstvid() {
        return dstvid;
    }

    public void setDstvid(String dstvid) {
        this.dstvid = dstvid;
    }

    public String getDstpid() {
        return dstpid;
    }

    public void setDstpid(String dstpid) {
        this.dstpid = dstpid;
    }

    public Byte getComputerStatus() {
        return computerStatus;
    }

    public void setComputerStatus(Byte computerStatus) {
        this.computerStatus = computerStatus;
    }

    public Byte getIsFileDelete() {
        return isFileDelete;
    }

    public void setIsFileDelete(Byte isFileDelete) {
        this.isFileDelete = isFileDelete;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getReverseId() {
        return reverseId;
    }

    public void setReverseId(String reverseId) {
        this.reverseId = reverseId;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getSuspectNum() {
        return suspectNum;
    }

    public void setSuspectNum(Integer suspectNum) {
        this.suspectNum = suspectNum;
    }

    public String getClassifiedDesc() {
        return classifiedDesc;
    }

    public void setClassifiedDesc(String classifiedDesc) {
        this.classifiedDesc = classifiedDesc;
    }

    public Long getRangeTime() {
        return rangeTime;
    }

    public void setRangeTime(Long rangeTime) {
        this.rangeTime = rangeTime;
    }

    @Override
    public String toString() {
        return "GmTestMessage{" +
                "fileCode='" + fileCode + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}