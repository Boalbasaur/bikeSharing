/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class Utils {
    
    public long hoursBetween(Calendar startDate, Calendar endDate) {
        long end = endDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toHours(Math.abs(end - start));
    }

}
