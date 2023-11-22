package MeetingScheduler;

import java.util.List;

public class Meeting {
    String meetingId;
    String meetingRoomId;
    TimeSlot meetingTiming;
    String description;
    String userId;
    MeetingStatus status;

    public Meeting(String meetingId, String meetingRoomId, TimeSlot meetingTiming, String description, String userId, MeetingStatus status) {
        this.meetingId = meetingId;
        this.meetingRoomId = meetingRoomId;
        this.meetingTiming = meetingTiming;
        this.description = description;
        this.userId = userId;
        this.status = status;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public TimeSlot getMeetingTiming() {
        return meetingTiming;
    }

    public void setMeetingTiming(TimeSlot meetingTiming) {
        this.meetingTiming = meetingTiming;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public MeetingStatus getStatus() {
        return status;
    }

    public void setStatus(MeetingStatus status) {
        this.status = status;
    }
}
