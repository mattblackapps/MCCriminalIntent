package com.matthewcoggin.sd2550.mccriminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by MC on 8/14/16.
 */
public class DatePickerFragment extends DialogFragment {
	public static final String EXTRA_DATE = "com.matthewcoggin.sd2550.mccriminalintent.date";

	private Date mDate;

	public static DatePickerFragment newInstance(Date date) {

		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DATE, date);

		DatePickerFragment fragment = new DatePickerFragment();
		fragment.setArguments(args);

		return fragment;
	}

	private void sendResult(int resultCode) {
		if (getTargetFragment() == null) return;

		Intent i = new Intent();
		i.putExtra(EXTRA_DATE, mDate);

		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		mDate = (Date)getArguments().getSerializable(EXTRA_DATE);

		//Create a Calendar to get the year, month and day
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(mDate);
		final int YEAR = calendar.get(Calendar.YEAR);
		final int MONTH = calendar.get(Calendar.MONTH);
		final int DAY = calendar.get(Calendar.DAY_OF_MONTH);

		View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);

		DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
		datePicker.init(YEAR, MONTH, DAY, new DatePicker.OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
				//Translate year, month, day into a Date object using a calendar
				mDate = new GregorianCalendar(i, i1, i2).getTime();

				// Update argument to preserve selected value on rotation
				getArguments().putSerializable(EXTRA_DATE, mDate);
			}
		});

		return new AlertDialog.Builder(getActivity())
				.setView(v)
				.setTitle(R.string.date_picker_title)
				.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								sendResult(Activity.RESULT_OK);
							}
						})
				.create();
	}
}
