import 'react-native-gesture-handler';
import * as React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';
import boxData from '../data/boxData';

export default function BoxesContainers() {
    return (
        <View style={styles.wrapper}>
            {boxData.map((props, id) => (
                <TouchableOpacity key={id} style={styles.container} >
                    <Image source={require('../assets/images/rightArrow.png')} style={styles.arrow} />
                    <View style={styles.idAndDate}>
                        <Text style={styles.idAndDateText}>Box #{props.boxID} - </Text>
                        <Text style={styles.idAndDateText}>{props.date}</Text>
                        <View style={styles.square}>
                            <Image source={require('../assets/images/closedBox.png')} style={styles.box} />
                        </View>
                    </View>
                    <Text style={styles.city}>{props.city}, {props.zipCode}</Text>
                    <Text style={styles.city}>{props.direction}</Text>

                    <View style={styles.statusWrapper}>
                        <Text style={styles.deliveryText}>{props.status}</Text>
                        <Image source={props.image} style={styles.statusImage} />
                    </View>
                </TouchableOpacity>
            )
            )}
        </View>
    )
}
const styles = StyleSheet.create({
    wrapper: {
        marginBottom: 30
    },
    container: {
        width: 375,
        marginLeft: 20,
        marginTop: 15,
        backgroundColor: '#fff',
        borderRadius: 13,
        shadowOffset: {
            height: 4,
        },
        shadowColor: '#000',
        shadowOpacity: 0.1,
        overflow:"scroll",
    },
    idAndDate: {
        flexDirection: "row",
        marginLeft: 67,
        marginTop: 16,
        marginBottom: 5
    },
    idAndDateText: {
        fontFamily: "SFProRoundedRegular",
        fontSize: 15,
        color: '#8A8A8E',
    },
    square: {
        marginLeft: -52,
        height: 40,
        width: 40,
        position: "absolute",
        backgroundColor: '#E8E8E9',
        borderRadius: 6,
        alignItems: "center",
    },
    box: {
        marginVertical: '20%',
        width: 25,
        height: 25
    },
    arrow: {
        position: "absolute",
        marginLeft: 350,
        marginTop: 55,
        width: 8,
        height: 14
    },
    city: {
        marginRight:50,
        marginLeft: 67,
        marginTop: 0,
        fontFamily: "SFProRoundedRegular",
        fontSize: 18,
        color: '#000',
    },
    statusWrapper: {
        flexDirection: "row",
        alignItems: "center",
    },
    deliveryText: {
        marginLeft: 67,
        marginTop: 5,
        marginBottom: 15,
        fontFamily: "SFProRoundedMedium",
        fontSize: 18,
        color: '#000',
    },
    statusImage: {
        marginRight:50,
        marginBottom: 11,
        marginLeft: 7,
        height: 18,
        width: 18,
    },
});


