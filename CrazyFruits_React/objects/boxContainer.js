import 'react-native-gesture-handler';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';
import boxData from '../data/boxData';
import { opacity } from 'jimp';



export default function BoxesContainers() {
    return (
        <View>
            {boxData.map((props) => (
                <View style={styles.container}>
                    <View style={styles.idAndDate}>
                        <Text style={styles.idAndDateText}>Box #{props.boxID} - </Text>
                        <Text style={styles.idAndDateText}>{props.date}</Text>
                        <View style={styles.square}>
                            <Image source={require('../assets/images/closedBox.png')} style={styles.box} />
                        </View>
                    </View>
                    <Text style={styles.city}>{props.city}, {props.zipCode}</Text>
                    <Text style={styles.city}>{props.direction}</Text>
                    <Text style={styles.deliveryText}>{props.status}</Text>
                </View>
            )
            )}
        </View>
    )
}
const styles = StyleSheet.create({

    container: {
        width: 375,
        height: 116,
        marginLeft: 20,
        marginTop: 15,
        backgroundColor: '#fff',
        borderRadius: 13,
        shadowOffset: {
            height: 4,
        },
        shadowColor: '#000',
        shadowOpacity: 0.1,
    },
    idAndDate: {
        flexDirection: "row",
        marginLeft: 58,
        marginTop: 16,
    },
    idAndDateText: {
        fontFamily: "SFProTextRegular",
        fontSize: 13,
        color: '#8A8A8E',
    },
    square: {
        marginLeft: -43,
        height: 32,
        width: 32,
        position: "absolute",
        backgroundColor: '#E8E8E9',
        borderRadius: 6,
        alignItems:"center",

    },
    box: {
        marginVertical: '25%',
        width: 16,
        height: 16
    },
    city:{
        marginLeft:58,
        marginTop:4,
        fontFamily: "SFProTextRegular",
        fontSize: 15,
        color: '#000',
    },
    deliveryText:{
        marginLeft:58,
        marginTop:4,
        fontFamily: "SFProTextMedium",
        fontSize: 15,
        color: '#000',
    },
});


