package com.example.admin.bluetoothsniffer;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bluetoothview.MyCustomView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/13/2017.
 */

public class BluetoothRecyclerAdapter extends RecyclerView.Adapter<BluetoothRecyclerAdapter.ViewHolder> {

    private List<BluetoothDevice> devices;

    public BluetoothRecyclerAdapter() {
        devices = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_bluetooth_device, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.tvDevice.setText(devices.get(position).getName());
        //holder.tvDeviceAddress.setText(devices.get(position).getAddress());
        String s = devices.get(position).getName();
        if(s != null) {
            holder.mcvDevice.setName(s);
        }
        else
            holder.mcvDevice.setName("");
        holder.mcvDevice.setAddress(devices.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void addDevice(BluetoothDevice bluetoothDevice) {
        if (!devices.contains(bluetoothDevice))
            devices.add(bluetoothDevice);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private final TextView tvDevice;
        //private final TextView tvDeviceAddress;
        private final MyCustomView mcvDevice;

        public ViewHolder(View itemView) {
            super(itemView);
            //tvDevice = itemView.findViewById(R.id.tvDevice);
            //tvDeviceAddress = itemView.findViewById(R.id.tvDeviceAddress);
            mcvDevice = itemView.findViewById(R.id.mcvDevice);
        }
    }
}
