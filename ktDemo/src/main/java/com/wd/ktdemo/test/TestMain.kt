package com.wd.ktdemo.test

/**
 * @author wudi
 * @desc
 * @time 2022-08-29 13:48
 */
class TestMain {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val text = """
                |多行字符串
                |编程狮
                |多行字符串
                |W3cschool"""
//            println(text)    // 前置空格删除了 .trimMargin()

            var a="v=0\n" +
                    "                                                                                                    o=- 1876003410614680097 2 IN IP4 192.168.1.104\n" +
                    "                                                                                                    s=-\n" +
                    "                                                                                                    t=0 0\n" +
                    "                                                                                                    a=group:BUNDLE audio video\n" +
                    "                                                                                                    a=msid-semantic: WMS ARDAMS\n" +
                    "                                                                                                    a=ice-lite\n" +
                    "                                                                                                    m=audio 8000 UDP/TLS/RTP/SAVPF 111\n" +
                    "                                                                                                    c=IN IP4 192.168.1.104\n" +
                    "                                                                                                    a=rtcp:8000 IN IP4 192.168.1.104\n" +
                    "                                                                                                    a=ice-ufrag:zlm_2\n" +
                    "                                                                                                    a=ice-pwd:kIMU5cfLLpdibJZCJFqcxy7V\n" +
                    "                                                                                                    a=ice-options:trickle\n" +
                    "                                                                                                    a=fingerprint:sha-256 B2:70:09:F9:1B:A6:FA:CB:75:98:20:CE:98:C3:72:C0:88:DB:22:2A:B3:47:0D:3C:9B:2D:CB:D8:08:DF:41:55\n" +
                    "                                                                                                    a=setup:passive\n" +
                    "                                                                                                    a=mid:audio\n" +
                    "                                                                                                    a=ice-lite\n" +
                    "                                                                                                    a=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\n" +
                    "                                                                                                    a=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\n" +
                    "                                                                                                    a=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\n" +
                    "                                                                                                    a=inactive\n" +
                    "                                                                                                    a=rtcp-mux\n" +
                    "                                                                                                    a=rtpmap:111 opus/48000/2\n" +
                    "                                                                                                    a=rtcp-fb:111 transport-cc\n" +
                    "                                                                                                    a=fmtp:111 minptime=10;useinbandfec=1\n" +
                    "                                                                                                    a=msid:zlmediakit-mslabel zlmediakit-label\n" +
                    "                                                                                                    a=ssrc:2 cname:zlmediakit-rtp\n" +
                    "                                                                                                    a=ssrc:2 msid:zlmediakit-mslabel zlmediakit-label\n" +
                    "                                                                                                    a=ssrc:2 mslabel:zlmediakit-mslabel\n" +
                    "                                                                                                    a=ssrc:2 label:zlmediakit-label\n" +
                    "                                                                                                    a=candidate:udpcandidate 1 udp 120 192.168.1.104 8000 typ host\n" +
                    "                                                                                                    a=candidate:tcpcandidate 1 tcp 115 192.168.1.104 8000 typ host tcptype passive\n" +
                    "                                                                                                    m=video 8000 UDP/TLS/RTP/SAVPF 124\n" +
                    "                                                                                                    c=IN IP4 192.168.1.104\n" +
                    "                                                                                                    a=rtcp:8000 IN IP4 192.168.1.104\n" +
                    "                                                                                                    a=ice-ufrag:zlm_2\n" +
                    "                                                                                                    a=ice-pwd:kIMU5cfLLpdibJZCJFqcxy7V\n" +
                    "                                                                                                    a=ice-options:trickle\n" +
                    "                                                                                                    a=fingerprint:sha-256 B2:70:09:F9:1B:A6:FA:CB:75:98:20:CE:98:C3:72:C0:88:DB:22:2A:B3:47:0D:3C:9B:2D:CB:D8:08:DF:41:55\n" +
                    "                                                                                                    a=setup:passive\n" +
                    "                                                                                                    a=mid:video\n" +
                    "                                                                                                    a=ice-lite\n" +
                    "                                                                                                    a=extmap:14 urn:ietf:params:rtp-hdrext:toffset\n" +
                    "                                                                                                    a=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\n" +
                    "                                                                                                    a=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\n" +
                    "                                                                                                    a=extmap:5 http://www.webrtc.org/experiments/rtp-hdrext/playout-delay\n" +
                    "                                                                                                    a=extmap:6 http://www.webrtc.org/experiments/rtp-hdrext/video-content-type\n" +
                    "                                                                                                    a=extmap:7 http://www.webrtc.org/experiments/rtp-hdrext/video-timing\n" +
                    "                                                                                                    a=extmap:8 http://www.webrtc.org/experiments/rtp-hdrext/color-space\n" +
                    "                                                                                                    a=sendonly\n" +
                    "                                                                                                    a=rtcp-mux\n" +
                    "                                                                                                    a=rtpmap:124 H264/90000\n" +
                    "                                                                                                    a=rtcp-fb:124 ccm fir\n" +
                    "                                                                                                    a=rtcp-fb:124 goog-remb\n" +
                    "                                                                                                    a=rtcp-fb:124 nack\n" +
                    "                                                                                                    a=rtcp-fb:124 nack pli\n" +
                    "                                                                                                    a=rtcp-fb:124 transport-cc\n" +
                    "                                                                                                    a=fmtp:124 level-asymmetry-allowed=1;packetization-mode=1;profile-level-id=640c1f\n" +
                    "                                                                                                    a=msid:zlmediakit-mslabel zlmediakit-label\n" +
                    "                                                                                                    a=ssrc:1 cname:zlmediakit-rtp\n" +
                    "                                                                                                    a=ssrc:1 msid:zlmediakit-mslabel zlmediakit-label\n" +
                    "                                                                                                    a=ssrc:1 mslabel:zlmediakit-mslabel\n" +
                    "                                                                                                    a=ssrc:1 label:zlmediakit-label\n" +
                    "                                                                                                    a=candidate:udpcandidate 1 udp 120 192.168.1.104 8000 typ host\n" +
                    "                                                                                                    a=candidate:tcpcandidate 1 tcp 115 192.168.1.104 8000 typ host tcptype passive"
            a=a.replace("inactive","sendrecv")
            println(a)
        }
    }

}