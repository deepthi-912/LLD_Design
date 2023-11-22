package MeetingScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    HashMap<String, Meeting> calenderMeetingsList = new HashMap<>();
    HashMap<String, MeetingRoom> meetingRoomsList = new HashMap<>();
    HashMap<String, User> usersList;

    MeetingRoom bookMeeting(TimeSlot timeSlot, String userId) throws IllegalAccessException {
        for(Map.Entry<String, MeetingRoom> entry : this.meetingRoomsList.entrySet()) {
            List<Meeting> meetingsList = getMeetingsByRoom(entry.getValue().meetingRoomId);
            boolean flag = false;
            for(int i=0;i<meetingsList.size();i++) {
                if(isBooked(meetingsList.get(i).getMeetingTiming(), timeSlot)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                this.calenderMeetingsList.put(entry.getKey(), new Meeting("", entry.getValue().meetingRoomId, timeSlot, "description", userId , MeetingStatus.BOOKED));
                return entry.getValue();
            }
        }
        return null;
    }

    boolean isBooked(TimeSlot timeSlot1, TimeSlot timeSlot2) {
        if(timeSlot1.getEntryTime().compareTo(timeSlot2.getEntryTime())>0 && timeSlot1.getEntryTime().compareTo(timeSlot2.getExitTime())<0 || (timeSlot1.getEntryTime().compareTo(timeSlot2.getEntryTime())<0 && timeSlot1.getExitTime().compareTo(timeSlot2.entryTime)>0)) {
            return true;
        }
        return false;
    }
    List<Meeting> getMeetingsByRoom(String meetingRoomId) throws IllegalAccessException {
        if(this.calenderMeetingsList.get(meetingRoomId) != null) {
            List<Meeting> meetingsList = new ArrayList<>();
            for(Map.Entry<String, Meeting> entry : calenderMeetingsList.entrySet()) {
                if(entry.getValue().getMeetingId().equals(meetingRoomId)) {
                    meetingsList.add(entry.getValue());
                }
            }
            return meetingsList;
        }
        throw new IllegalAccessException("No such meeting exists");
    }

    void cancelMeeting(String meetingId) throws IllegalAccessException {
        if(this.calenderMeetingsList.get(meetingId) != null) {
            this.calenderMeetingsList.get(meetingId).status = MeetingStatus.CANCELLED;
        } else {
            throw new IllegalAccessException("Meeting doesn't exist");
        }
    }

}
