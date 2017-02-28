package example.toong.testrealmapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder(this).name(Realm.DEFAULT_REALM_NAME)
                        .schemaVersion(0)
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(realmConfiguration);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Book book = realm.createObject(Book.class); // Create managed objects directly
        book.setId((int) Math.random());
        book.setTitle("s");
        realm.commitTransaction();
        realm.copyToRealm(book);

        String a = "     <p>vgdgffdgdgfdfgdfgdfgdfgdfg..........</p><p><em>aererwerewrwerwer</em></p><h2><span\n"
                + "     class=\"marker\"><em>yyiyuiuuyuuyiyiuy</em></span></h2><blockquote>\n"
                + "     <p><samp>hjjgjhghghgjhgjhgj</samp></p></blockquote><ul><li>gtttggttt</li><li>ghgggggg&nbsp;</li></ul>";

    }
}
