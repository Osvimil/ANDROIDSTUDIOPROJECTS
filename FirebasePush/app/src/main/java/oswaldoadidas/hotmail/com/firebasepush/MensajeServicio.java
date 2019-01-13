package oswaldoadidas.hotmail.com.firebasepush;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by oswaldosaldivar on 02/04/17.
 */

public class MensajeServicio extends FirebaseMessagingService {

    public void onMessageReceived(RemoteMessage remoteMessage){
        Intent intent = new Intent(this, MainActivity.class);


        if(remoteMessage.getData().size()>0){
            String mensaje = remoteMessage.getData().get("Mensajito");
            Bundle bundle = new Bundle();
            bundle.putString("Mensaje",mensaje);
            intent.putExtras(bundle);
        }


        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder ncb = new NotificationCompat.Builder(this);
        ncb.setContentTitle("NOTIFICACION");
        ncb.setContentText(remoteMessage.getNotification().getBody());
        ncb.setAutoCancel(true);
        ncb.setSmallIcon(R.mipmap.ic_launcher);
        ncb.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0,ncb.build());


    }
}
