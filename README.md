# space-allocation
CS3716 Group 8


DOCUMENTATION

Saving and Loading:

  Example of saving/loading Schedules:

    List<Schedule> schedules;
    SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule);
    scheduleIO.save(schedules);
    List<Schedule> schedules = scheduleIO.load();

