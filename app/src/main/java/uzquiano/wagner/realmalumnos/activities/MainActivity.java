package uzquiano.wagner.realmalumnos.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import uzquiano.wagner.realmalumnos.R;
import uzquiano.wagner.realmalumnos.adapters.MyAdapter;
import uzquiano.wagner.realmalumnos.models.Alumno;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Alumno>> {

    private ListView listView;
    private GridView gridView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResults<Alumno> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        //listView = (ListView) findViewById(R.id.listView);
        gridView = (GridView) findViewById(R.id.GridView);

        people = getAllPeople();
        people.addChangeListener(this);

        adapter = new MyAdapter(people, R.layout.grid_item_view, this);

        gridView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addPeople();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private RealmResults<Alumno> getAllPeople() {
        return realm.where(Alumno.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {



                Alumno p1 = new Alumno("218700780","Diego","Huanaco",18,"ICIN",2012,"primero");
                Alumno p2 = new Alumno("132456789","Manuel","Perez",20,"ICIN",2015,"primero");
                Alumno p3 = new Alumno("123123423","Francisco","uzquiano",16,"ICIN",2015,"primero");
                Alumno p4 = new Alumno("169874563","Rodrigo","uzquiano",22,"ICIN",2014,"primero");
                Alumno p5 = new Alumno("216579846","Jorge","uzquiano",16,"ICIN",2013,"primero");
                Alumno p6 = new Alumno("156486489","Wagner","uzquiano",34,"ICIN",2014,"primero");
                Alumno p7 = new Alumno("187894658","Sebastian","uzquiano",25,"ICIN",2013,"primero");
                Alumno p8 = new Alumno("121345646","Atsuko","uzquiano",22,"ICIN",2012,"primero");
                Alumno p9 = new Alumno("203456478","Matias","uzquiano",20,"ICIN",2013,"primero");
                Alumno p10 = new Alumno("196536451","Diego","uzquiano",19,"ICIN",2016,"primero");
                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);
                realm.copyToRealmOrUpdate(p4);
                realm.copyToRealmOrUpdate(p5);
                realm.copyToRealmOrUpdate(p6);
                realm.copyToRealmOrUpdate(p7);
                realm.copyToRealmOrUpdate(p8);
                realm.copyToRealmOrUpdate(p9);
                realm.copyToRealmOrUpdate(p10);

                people = getAllPeople();
            }
        });
    }
}
