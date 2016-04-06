package com.example.c07656.matcontrols;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    Document doc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MatMainActivity", "Start Programs!!");

        Spinner spinner = (Spinner) findViewById(R.id.listSpin);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.projectlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, HomeActivity.class);
                //MainActivity.this.startActivity(i);
                LoginTask task = new LoginTask();
                task.execute("http://10.60.35.57:8081/skpcm/user?us=skpcmsystem&pw=skpcmadmin&prj_id=PJ0000000004");
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Document> {

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(MainActivity.this, "", "Loading...");
            super.onPreExecute();
        }

        @Override
        protected Document doInBackground(String... urls) {
            URL url;

            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Log.d("MatMainActivity_Login", e.getLocalizedMessage());
            }

            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {
            String s = "";
            NodeList nodeList = doc.getElementsByTagName("user");

            for(int i = 0; i<nodeList.getLength(); i++) {
                s += "" +i + ": 유저 정보: ";
                Node node = nodeList.item(i); //data엘리먼트 노드
                Element fstElmnt = (Element) node;
                NodeList nameList  = fstElmnt.getElementsByTagName("name");
                Element nameElement = (Element) nameList.item(0);
                nameList = nameElement.getChildNodes();
                s += "아이디 = "+ ((Node) nameList.item(0)).getNodeValue() +" ,";

                NodeList websiteList = fstElmnt.getElementsByTagName("prj");
                s += "프로젝트 = "+  websiteList.item(0).getChildNodes().item(0).getNodeValue() +"\n";
            }

            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

            super.onPostExecute(doc);

            dialog.dismiss();
        }
    }
}
