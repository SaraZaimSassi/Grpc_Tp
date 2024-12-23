import app.grpc.User;
import app.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static app.grpc.userGrpc.newBlockingStub;

public class ClientGrpc {
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",9001).usePlaintext().build();
        userGrpc.userBlockingStub userStub = newBlockingStub(channel);
        User.LoginRequest login= User.LoginRequest.newBuilder().setUserName("GRPC").setPassword("GRPC").build();
        User.LoginResponse response=userStub.login(login);
        System.out.println(response.getMsgResponse());
        channel.shutdown();
    }
}
