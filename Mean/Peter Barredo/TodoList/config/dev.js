/**
 * Created by JIANGDA2 on 7/29/2016.
 */
'use strict';

module.exports = {
    contextPath: '/todo',
    // The secret should be set to a non-guessable string that
    // is used to compute a session hash
    sessionSecret: 'todo',
    // The name of the MongoDB collection to store sessions in
    sessionCollection: 'sessions',
    // The session cookie settings
    sessionCookie: {
        path: '/',
        httpOnly: true,
        // If secure is set to true then it will cause the cookie to be set
        // only when SSL-enabled (HTTPS) is used, and otherwise it won't
        // set a cookie. 'true' is recommended yet it requires the above
        // mentioned pre-requisite.
        secure: false,
        // Only set the maxAge to null if the cookie shouldn't be expired
        // at all. The cookie will expunge when the browser is closed.
        maxAge: null,
        // To set the cookie in a specific domain uncomment the following
        // setting:
        // domain: 'yourdomain.com'
    },
    // The session cookie name
    sessionName: 'connect.sid',
    port: 3342,
    url: 'http://localhost:3343',
    mongodb: {
        uri: 'mongodb://zha-ita098-w7:27017/todo',
        options: {
            server: {
                socketOptions: {connectTimeoutMS: 10000}
            }
        },
        debug: true
    }
};
