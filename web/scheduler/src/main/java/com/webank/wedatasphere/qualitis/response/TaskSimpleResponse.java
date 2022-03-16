/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.qualitis.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webank.wedatasphere.qualitis.entity.Task;

/**
 * @author howeye
 */
public class TaskSimpleResponse {

    @JsonProperty("task_id")
    private Long taskId;
    @JsonProperty("task_status")
    private Integer taskStatus;
    @JsonProperty("cluster_name")
    private String clusterName;
    @JsonProperty("abort_on_failure")
    private Boolean abortOnFailure;

    public TaskSimpleResponse() {
    }

    public TaskSimpleResponse(Task task) {
        this.taskId = task.getTaskRemoteId();
        this.taskStatus = task.getStatus();
        this.clusterName = task.getClusterName();
        this.abortOnFailure = task.getAbortOnFailure();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Boolean getAbortOnFailure() {
        return abortOnFailure;
    }

    public void setAbortOnFailure(Boolean abortOnFailure) {
        this.abortOnFailure = abortOnFailure;
    }

    @Override
    public String toString() {
        return "TaskSimpleResponse{" +
                "taskId=" + taskId +
                ", taskStatus=" + taskStatus +
                ", clusterName='" + clusterName + '\'' +
                '}';
    }
}
