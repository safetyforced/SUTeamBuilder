package alexmarks.suteambuilder;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mTeamAdapter1;
    private ArrayAdapter<String> mTeamAdapter2;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] teamArray1 = new String[2];

        String[] teamArray2 = new String[2];
        Integer index;
        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            index = rand.nextInt(42) + 1;
            teamArray1[i] = Integer.toString(index);
            index = rand.nextInt(42) + 1;
            teamArray2[i] = Integer.toString(index);

        }

        ArrayList<String> teamSet1 = new ArrayList<>(
                Arrays.asList(teamArray1)
        );

        ArrayList<String> teamSet2 = new ArrayList<>(
                Arrays.asList(teamArray2)
        );


        mTeamAdapter1 =
                new ArrayAdapter<>(
                        //use getActivity() as context, no idea how that works yet
                        getActivity(),
                        //write path to layout XML file
                        R.layout.list_item_team1,
                        //specify textview from layout
                        R.id.list_item_team_textview1,
                        //variable used to contain data (arraylist)
                        teamSet1);

        mTeamAdapter2 =
                new ArrayAdapter<>(
                        //use getActivity() as context, no idea how that works yet
                        getActivity(),
                        //write path to layout XML file
                        R.layout.list_item_team2,
                        //specify textview from layout
                        R.id.list_item_team_textview2,
                        //variable used to contain data (arraylist)
                        teamSet2);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView1 = (ListView) rootView.findViewById(R.id.listview_team1);
        listView1.setAdapter(mTeamAdapter1);

        ListView listView2 = (ListView) rootView.findViewById(R.id.listview_team2);
        listView2.setAdapter(mTeamAdapter2);

        return rootView;
    }
}
