package scwarzcopv.mobile.menumakanan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.annotation.NonNull;
import android.view.MenuItem;

public class Menu_Detail_Makanan extends AppCompatActivity {

    String HargaItem, NamaItem, Deskripsi, NomorHP, Lat, Long;
    int Gambar;
    int position;
    TextView tvHarga, tvNamaItem, tvDeskripsi, tvNomorHP;
    ImageView ImgGembar;
    Button btnPesan;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail_makanan);

        // Panggil act.bar
        ActionBar actionBar = getSupportActionBar();
        // Menampilkan back button pada act.bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvHarga		    = (TextView)findViewById(R.id.textView1);
        tvNamaItem		= (TextView)findViewById(R.id.textView2);
        tvDeskripsi		= (TextView)findViewById(R.id.textView3);
        ImgGembar		= (ImageView)findViewById(R.id.imageView1);
        tvNomorHP		= (TextView)findViewById(R.id.textView);
        btnPesan		= (Button)findViewById(R.id.button);

        Intent i 		= getIntent();
        position 		= i.getExtras().getInt("position");
        HargaItem		= i.getStringExtra("HargaItem");
        NamaItem		= i.getStringExtra("NamaItem");
        Deskripsi	 	= i.getStringExtra("Deskripsi");
        NomorHP 	 	= i.getStringExtra("NomorHP");
        Gambar			= i.getIntExtra("Gambar", Gambar);
        Lat 	 	    = i.getStringExtra("Lat");
        Long 	 	    = i.getStringExtra("Long");

        tvHarga.setText(HargaItem);
        tvNamaItem.setText(NamaItem);
        tvDeskripsi.setText(Deskripsi);
        tvNomorHP.setText(NomorHP);
        ImgGembar.setImageResource(Gambar);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://api.whatsapp.com/send?phone="+NomorHP+"&text=Saya memesan makanan : \n"+NamaItem+"\n\nSebanyak :"));
                startActivity(i);
            }
        });
    }

    // Fungsi back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
