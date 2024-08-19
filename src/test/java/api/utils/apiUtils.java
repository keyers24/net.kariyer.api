package api.utils;

import org.json.JSONObject;
import java.util.List;

public class apiUtils {
    public static JSONObject createSearchPayload(int memberId, int size, int currentPage, String keyword, List<Integer> language, boolean dontShowAppliedJobs) {
        JSONObject payload = new JSONObject();
        payload.put("memberId", memberId);
        payload.put("size", size);
        payload.put("currentPage", currentPage);
        payload.put("keyword", keyword);
        payload.put("language", language);
        payload.put("dontShowAppliedJobs", dontShowAppliedJobs);
        return payload;
    }
}
