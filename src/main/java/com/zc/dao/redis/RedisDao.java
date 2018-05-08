package com.zc.dao.redis;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.zc.entity.Student;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
    private final JedisPool jedisPool;

    private final RuntimeSchema<Student> schema = RuntimeSchema.createFrom(Student.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Student getStudent(Long sid,String password){
        try{
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "sid" + sid +"password" + password;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    Student student = schema.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes,student,schema);
                    return student;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String putStudent(Student student){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "sid" + student.getSid();
                byte[] bytes = ProtobufIOUtil.toByteArray(student,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
