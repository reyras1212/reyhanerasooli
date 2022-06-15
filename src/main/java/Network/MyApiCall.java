package Network;

import com.example.falhafez.poets;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    @GET ("api/ganjoor/poets")
    Call <List<poets>> getData();
}
