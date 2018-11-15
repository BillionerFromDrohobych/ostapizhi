package misterpanchak.com.mapich;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context cityContext;
    private List<City> cityList;
    Intent intent;
    public RecyclerViewAdapter(Context cityContext, List<City> cityList) {
        this.cityContext = cityContext;
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater cInflater = LayoutInflater.from(cityContext);
        view = cInflater.inflate(R.layout.cardview, viewGroup, false);

        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.CityTextView.setText(cityList.get(i).getName());
        myViewHolder.CityImageView.setImageResource(cityList.get(i).getImgUrl());
        myViewHolder.CityCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise( cityList.get(i).getName(),
                        cityList.get(i).getImgUrl(),
                        cityList.get(i).getImgUrl1(),
                        cityList.get(i).getImgUrl2(),
                        cityList.get(i).getLocation(),
                        cityList.get(i).getDesctription(),
                        cityList.get(i).getSightorcity(),
                        cityList.get(i).getAdress());

            }


        });


    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public void choise(String name, int imgurl, int imgUrl1, int imgUrl2, String location, String desctription, boolean sightorcity, String adress) {
        intent = new Intent(cityContext, SightActivity.class);
        if (sightorcity == false) {
            switch (name) {
                case "Kyiv":
                    cityList.clear();
                    cityList.add(new City("KPI", R.drawable.unnamed, R.drawable.unnamed, R.drawable.unnamed, "geo:50.454978,30.445443?q=Igor Sikorsky Kyiv Polytechnic Institute", "s", true, "vul. Saint Ostapuchi"));
                    cityList.add(new City("KPI2", R.drawable.unnamed, R.drawable.unnamed, R.drawable.unnamed, "geo:50.454978,30.445443?q=Igor Sikorsky Kyiv Polytechnic Institute", "s", true, "vul. Saint Ostapuchi"));
                    cityList.add(new City("KPI3", R.drawable.unnamed, R.drawable.unnamed, R.drawable.unnamed, "geo:50.454978,30.445443?q=Igor Sikorsky Kyiv Polytechnic Institute", "s", true, "vul. Saint Ostapuchi"));
                    break;
                case "Lviv":
                    cityList.clear();
                    cityList.add(new City("LP", R.drawable.unnamed, R.drawable.unnamed, R.drawable.unnamed, "geo:50.454978,30.445443?q=Igor Sikorsky Kyiv Polytechnic Institute", "s", true, "vul. Saint Ostapuchi"));
                    cityList.add(new City("LP2", R.drawable.unnamed, R.drawable.unnamed, R.drawable.unnamed, "geo:50.454978,30.445443?q=Igor Sikorsky Kyiv Polytechnic Institute", "s", true, "vul. Saint Ostapuchi"));
                    cityList.add(new City("LP3", R.drawable.unnamed, R.drawable.unnamed, R.drawable.unnamed, "geo:50.454978,30.445443?q=Igor Sikorsky Kyiv Polytechnic Institute", "s", true, "vul. Saint Ostapuchi"));
                    break;
            }
            }else if(sightorcity == true) {

                intent.putExtra("name",name);
                intent.putExtra("adress",adress);
                // intent.putExtra("description",description);
                intent.putExtra("imgurl",imgurl);
                intent.putExtra("imgUrl1",imgUrl1);
                intent.putExtra("imgUrl2",imgUrl2);
                intent.putExtra("location",location);

                cityContext.startActivity(intent);
            }

            notifyDataSetChanged();
        }
        //Search
    public void filteredListed(ArrayList<City> filteredList){
        cityList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView CityTextView;
        ImageView CityImageView;
        CardView CityCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            CityTextView = (TextView) itemView.findViewById(R.id.cityTextView);
            CityImageView = (ImageView) itemView.findViewById(R.id.cityImageView);
            CityCardView = (CardView) itemView.findViewById(R.id.CityCardView);

        }


    }
}
